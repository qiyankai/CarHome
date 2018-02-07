package com.carba.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carba.web.mapper.BrandMapper;
import com.carba.web.pojo.Brand;

@Service
public class BrandService {
	@Autowired
	private BrandMapper brandMapper;
	public List<Brand> queryAll() {
		List<Brand> list = new ArrayList<Brand>();
		List<Brand> brandList= brandMapper.queryBrand();
		for (Brand brand : brandList) {
			Brand br=brandMapper.queryAll(brand.getId());
			list.add(br);
		}
		return list;
	}

}
