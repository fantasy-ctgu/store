package com.ctgu.qmx.bean;

public class Commodity {
	private int id;
	private String commodity_name;
	private String username;
	private int commodity_type;
	private String datetime;
	private String commodity_content;
	private String commodity_money;
	private int commodity_school;
	public int getCommodity_school() {
		return commodity_school;
	}
	public void setCommodity_school(int commodity_school) {
		this.commodity_school = commodity_school;
	}
	private String img;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCommodity_type() {
		return commodity_type;
	}
	public void setCommodity_type(int commodity_type) {
		this.commodity_type = commodity_type;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getCommodity_content() {
		return commodity_content;
	}
	public void setCommodity_content(String commodity_content) {
		this.commodity_content = commodity_content;
	}
	public String getCommodity_money() {
		return commodity_money;
	}
	public void setCommodity_money(String commodity_money) {
		this.commodity_money = commodity_money;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

}
