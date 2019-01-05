package com.systexgc.entity;

public class Column {
	private String name;
	private String typename;
	private int isFlag; //是否标识
	
	public int getIsFlag() {
		return isFlag;
	}
	public void setIsFlag(int isFlag) {
		this.isFlag = isFlag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
}
