package com.jt.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.product.dao.ProductDao;
import com.jt.product.entity.Product;
import com.jt.product.service.ProducService;

@Service
public class ProductServiceImpl implements ProducService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public PageObject<Product> findPageObjects(
			String name, Integer display, Integer pageCurrent) {
		
		//1.验证参数合法性
		if(pageCurrent==null||pageCurrent<1){
			throw new ServiceException("参数不合法");
		}
		//2.查询总记录数
		int rowCount = productDao.getRowCount(name, display);
		if(rowCount==0){
			throw new ServiceException("没有记录");
		}
	    //2.查询当前页记录
		//2.1定义页面大小(每页最多现实多少条记录)
		int pageSize=5;
		//2.2计算当前页位置
		int startIndex=(pageCurrent-1)*pageSize;
		//2.3查询当前数据
		List<Product> list = productDao.findPageObjects(
				name, display, startIndex, pageSize);
		
		//3.封装数据
		PageObject<Product> pageObject=new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		
		return pageObject;
	}

	@Override
	public int updateDisplay(Integer display, Integer id) {
		//1. 验证数据有效性
		if(id==null||id<1){
			throw new IllegalArgumentException("id值不正确");
		}
		
		//2. 反转display参数值，执行sql操作
		display = display==0 ? 1 : 0;
		int rows = productDao.updateDisplay(display, id);
		if(rows==0){
			throw new ServiceException("商品可能已经不存在了");
		}
		//3. 返回结果集
		return rows;
	}

	@Override
	public int updateObject(Product entity) {
		//1.合法验证
		if(entity==null){
			throw new ServiceException("保存对象不能为空");
		}
		if(StringUtils.isEmpty(entity.getName())){
			throw new ServiceException("商品名不能为空");
		}
		if(entity.getPrice()==null){
			throw new ServiceException("商品价格不能为空");
		}
		if(entity.getStock()==null){
			throw new ServiceException("商品库存不能为空");
		}
		int rows;
		//2.更新数据
		try{
			rows = productDao.updateObject(entity);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceException("更新失败");
		}
		//3.返回数据
		return rows;
	}

	@Override
	public int saveObject(Product entity) {
		//1.合法验证
		if(entity==null){
			throw new ServiceException("保存对象不能为空");
		}
		if(StringUtils.isEmpty(entity.getName())){
			throw new ServiceException("商品名不能为空");
		}
		//2.保存数据
		int rows = productDao.insertObject(entity);
		//3.返回数据
		return rows;
	}

}



















