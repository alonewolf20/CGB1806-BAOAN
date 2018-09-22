package com.jt.order.ov;
/**
 * 订单和商品--中间表的实现类
 */
import java.io.Serializable;

public class OrderProduct implements Serializable{
	
	private static final long serialVersionUID = 7496909085214822859L;
	private Integer id;
	private String name;
	private String describes;
	private Integer number;
	private Double price;
	private Double totalPrices;
	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", name=" + name + ", describes=" + describes + ", number=" + number
				+ ", price=" + price + ", totalPrices=" + totalPrices + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(Double totalPrices) {
		this.totalPrices = totalPrices;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
