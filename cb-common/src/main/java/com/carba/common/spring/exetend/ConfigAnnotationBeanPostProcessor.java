package com.carba.common.spring.exetend;

import org.springframework.beans.BeansException;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Service
public class ConfigAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
	@Autowired
	private ExtendedPropertyPlaceholderConfigurer propertyConfigurer;

	private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

	/**
	 * <p>
	 * 通过config配置变量,bean初始化以后设置properties文件里面的值
	 * </p> {@inheritDoc}
	 */
	@Override
	public boolean postProcessAfterInstantiation(final Object bean, String beanName) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				PropertyConfig cfg = field.getAnnotation(PropertyConfig.class);
				if (cfg != null) {
					if (Modifier.isStatic(field.getModifiers())) {
						throw new IllegalStateException("@PropertyConfig annotation is not supported on static fields");
					}
					String key = cfg.value().length() <= 0 ? field.getName() : cfg.value();
					Object value = propertyConfigurer.getProperty(key);
					if (cfg.required() && value == null) {
						throw new NullPointerException(bean.getClass().getSimpleName() + "." + field.getName()
								+ "is requred,but not been configured");
					} else if (value != null) {
						Object _value = typeConverter.convertIfNecessary(value, field.getType());
						ReflectionUtils.makeAccessible(field);
						field.set(bean, _value);
					}
				}
			}
		});

		return true;
	}
}
