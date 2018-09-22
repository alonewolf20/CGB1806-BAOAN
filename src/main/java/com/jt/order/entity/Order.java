package com.jt.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Orders映射实体类
 */
public class Order implements Serializable{
	
	private static final long serialVersionUID = 7628339253220670865L;
	//订单id
	private Integer id;
	//订单号
	private String number;
	//订单状态
	private String type;
	//用户id
	private String userId;
	//用户名
	private String userName;
	//用户手机号码
	private String phone;
	//用户地址
	private String addr;
	//用户下单时间
	private Date orderTime;
	private Double totalPrices;
	
	public Order() {
		super();
	}
	public Order(Integer id, String number, String type, String userId, String userName, String phone, String addr,
			Date orderTime, Double totalPrices) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.addr = addr;
		this.orderTime = orderTime;
		this.totalPrices = totalPrices;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", type=" + type + ", userId=" + userId + ", userName="
				+ userName + ", phone=" + phone + ", addr=" + addr + ", orderTime=" + orderTime + ", totalPrices="
				+ totalPrices + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(Double totalPrices) {
		this.totalPrices = totalPrices;
	}
}
