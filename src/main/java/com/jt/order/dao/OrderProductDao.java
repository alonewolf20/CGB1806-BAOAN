package com.jt.order.dao;

import java.util.List;
import com.jt.order.ov.OrderProduct;

/**
 * 这了接口用来关联订单表和商品表
 * @author SZC
 *
 */
public interface OrderProductDao {
	
	/**
	 * 基于订单id查询商品id
	 * @param id
	 * @return
	 */
	List<OrderProduct> findProductByOrderId(Integer id);
}
