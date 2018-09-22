package com.jt.order.service;

import java.util.List;

import com.jt.common.vo.PageObject;
import com.jt.order.entity.Order;
import com.jt.order.ov.OrderProduct;

public interface OrderService {
	
	/**
	 * 查询当前页条目信息
	 * @param display
	 * @param pageCurrent
	 * @return
	 */
	PageObject<Order> findPageObjects(
    		Integer pageCurrent);
	
	/**
	 * 查询当前页条目信息
	 * @param pageCurrent
	 * @return
	 */
	List<OrderProduct> findOrderProductAll(Integer id);
}
