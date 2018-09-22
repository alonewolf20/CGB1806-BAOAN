package com.jt.product.service;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.PageObject;
import com.jt.product.entity.Product;

public interface ProducService {
	
	/**
	 * 基于id修改其他数值
	 * @param entity
	 * @return
	 */
	int updateObject(Product entity);
	
	/**
	 * 查询当前页条目信息
	 * @param name
	 * @param display
	 * @param pageCurrent
	 * @return
	 */
	PageObject<Product> findPageObjects(
			String name,
			Integer display,
    		Integer pageCurrent);
	
	/**
	 * 基于id修改商品是否显示(激活)(商品一经添加不允许删除)
	 * @return
	 */
	int updateDisplay(
			@Param("display")Integer display,
			@Param("id")Integer id);
	
	int saveObject(Product entity);
}
