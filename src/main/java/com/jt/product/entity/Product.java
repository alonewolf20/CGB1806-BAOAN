package com.jt.product.entity;
/**
 * 这个类用来映射sql中的Product表
 */
import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1453209510792865308L;
	//商品id
	private Integer id;
	//商品名称
	private String name;
	//商品价格
	private Double price;
	//商品库存
	private Integer stock;
	//商品属性
	private String type;
	//商品描述
	private String describes;
	//商品备注
	private String note;
	//商品显示标记值(0--不显示/1--显示)
	private Integer display = 1;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", type=" + type
				+ ", describes=" + describes + ", note=" + note + ", display=" + display + "]";
	}
	public Product() {
		super();
	}
	public Product(Integer id, String name, Double price, Integer stock, String type, String describes, String note,
			Integer display) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.type = type;
		this.describes = describes;
		this.note = note;
		this.display = display;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
}
