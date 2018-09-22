package com.jt.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.order.entity.Order;

public interface OrderDao {
	
	/**
     * 基于条件查询当前页数据
     * @param startIndex 当前起始位置
     * @param pageSize 每页最多显示的记录数,页面大小.
     * @return
     */
	List<Order> findPageObjects(
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 基于条件查询总记录数
	 * @param name 查询条件
	 * @return
	 */
	int getRowCount();
	
}


















