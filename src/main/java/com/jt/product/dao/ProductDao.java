package com.jt.product.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.jt.product.entity.Product;

public interface ProductDao {
	
	/**
	 * 基于id修改其他数值
	 * @param entity
	 * @return
	 */
	int updateObject(Product entity);
	
	/**
	 * 基于id修改商品是否显示(激活)(商品一经添加不允许删除)
	 * @return
	 */
	int updateDisplay(
			@Param("display")Integer display,
			@Param("id")Integer id);
	
	/**
	 * 负责将配置信息持久化
	 * @param entity
	 * @return
	 */
//	int insertObject(Product entity);
	
    /**
     * 基于条件查询当前页数据
     * @param name 查询时输出的参数名
     * @param startIndex 当前起始位置
     * @param pageSize 每页最多显示的记录数,页面大小.
     * @return
     */
	List<Product> findPageObjects(
			@Param("name")String name,
			@Param("display")Integer display,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 基于条件查询总记录数
	 * @param name 查询条件
	 * @return
	 */
	int getRowCount(
			@Param("name")String name,
			@Param("display")Integer display);
	
	int insertObject(Product entity);
	
	/**
	 * 根据id查询所有商品信息
	 * @param id
	 * @return
	 */
	List<Product> findObjectById(Integer... productIds);
}













