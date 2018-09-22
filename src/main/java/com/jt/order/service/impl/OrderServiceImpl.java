package com.jt.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.order.dao.OrderDao;
import com.jt.order.dao.OrderProductDao;
import com.jt.order.entity.Order;
import com.jt.order.ov.OrderProduct;
import com.jt.order.service.OrderService;
import com.jt.product.dao.ProductDao;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderProductDao orderProductDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public PageObject<Order> findPageObjects(Integer pageCurrent) {
		
		//1.验证参数合法性
		if(pageCurrent==null||pageCurrent<1){
			throw new ServiceException("参数不合法");
		}
		//2.查询总记录数
		int rowCount = orderDao.getRowCount();
		if(rowCount==0){
			throw new ServiceException("没有记录");
		}
	    //2.查询当前页记录
		//2.1定义页面大小(每页最多现实多少条记录)
		int pageSize=5;
		//2.2计算当前页位置
		int startIndex=(pageCurrent-1)*pageSize;
		//2.3查询当前数据
		List<Order> list = orderDao.findPageObjects(startIndex, pageSize);
		
		//3.封装数据
		PageObject<Order> pageObject=new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		
		return pageObject;
	}

	@Override
	public List<OrderProduct> findOrderProductAll(Integer id) {
		//1   验证参数合法性
		if(id == null){
			throw new ServiceException("id参数不合法");
		}
		
		List<OrderProduct> list = orderProductDao.findProductByOrderId(id);
		
		if(list.size()==0){
			throw new ServiceException("订单已经被删除了");
		}
		
		return list;
	}
}



















