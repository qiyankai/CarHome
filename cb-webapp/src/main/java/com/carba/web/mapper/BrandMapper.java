package com.carba.web.mapper;

import java.util.List;

import com.carba.web.pojo.Brand;

public interface BrandMapper {

	public Brand queryAll(int id);

	public List<Brand> queryBrand();

}
