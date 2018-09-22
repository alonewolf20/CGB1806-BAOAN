package com.jt.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.product.entity.Product;
import com.jt.product.service.ProducService;

@RequestMapping("/product/")
@Controller
public class ProductCotroller {
	
	@Autowired
	private ProducService producService;
	
	/**跳转到商品列表界面*/
	@RequestMapping("doProductListUI")
	public String doProductListUI() {
		return "product/product_list";
	}
	
	/**跳转到商品列表界面*/
	@RequestMapping("doProductEditUI")
	public String doProductEditUI() {
		return "product/product_edit";
	}
	
	//--------------------------------------------------------------------------
	
	/**添加商品信息*/
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Product entity) {
		
		producService.saveObject(entity);
		
		//返回结果集
		JsonResult jsonResult = new JsonResult("商品信息添加成功");
		return jsonResult;
	}
	
	/**根据id修改商品信息*/
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Product entity) {
		
		producService.updateObject(entity);
		
		//返回结果集
		JsonResult jsonResult = new JsonResult("商品信息修改成功");
		return jsonResult;
	}
	
	/**修改商品是否显示*/
	@RequestMapping("doUpdateDisplay")
	@ResponseBody
	public JsonResult doUpdateDisplay(
			Integer display,
			Integer id) {
		producService.updateDisplay(display, id);
		
		//返回结果集
		String value = display == 1 ? "商品信息删除成功" : "商品信息恢复成功";
    	JsonResult jsonResult = new JsonResult(value);
    	return jsonResult;
	}
	
	/**查询当前页面全部信息*/
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String name,
			Integer display,
    		Integer pageCurrent) {
		PageObject<Product> data = producService.findPageObjects(name, display, pageCurrent);
		JsonResult jsonResult = new JsonResult(data);
		
		return jsonResult;
	}
}
