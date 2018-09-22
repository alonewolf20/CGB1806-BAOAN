package com.jt.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.order.entity.Order;
import com.jt.order.ov.OrderProduct;
import com.jt.order.service.OrderService;

@RequestMapping("/order/")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 返回订单列表界面
	 * @return
	 */
	@RequestMapping("doOrderListUI")
	public String doOrderListUI(){
		return "order/order_list";
	}
	
	/**
	 * 返回订单详情列表界面
	 * @return
	 */
	@RequestMapping("doProductListUI")
	public String doProductListUI(){
		return "order/order_products";
	}
	
	/**
	 * 订单列表
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer pageCurrent){
		
		PageObject<Order> findPageObjects = orderService.findPageObjects(pageCurrent);
		JsonResult jsonResult = new JsonResult(findPageObjects);
		
		return jsonResult;
	}
	
	/**
	 * 查询订单关联的商品
	 * @return
	 */
	@RequestMapping("doFindProductList")
	@ResponseBody
	public JsonResult doFindProductList(
			Integer id){
		
		List<OrderProduct> findOrderProductAll = orderService.findOrderProductAll(id);
		JsonResult jsonResult = new JsonResult(findOrderProductAll);
		
		return jsonResult;
	}
	
}
















