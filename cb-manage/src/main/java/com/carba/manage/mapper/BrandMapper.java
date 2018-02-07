package com.carba.manage.mapper;


import com.carba.manage.pojo.Brand;
import com.carba.common.mapper.SysMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandMapper extends SysMapper<Brand> {
    void saveBrand(Brand brand);
}
