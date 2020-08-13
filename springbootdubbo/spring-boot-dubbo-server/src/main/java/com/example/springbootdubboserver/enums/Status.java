package com.example.springbootdubboserver.enums;

public enum Status {
	PUBLISHED("发布"),
	DRAFT("草稿"),
	DELETED("删除");
	private String desc;
	
	Status(String desc) {
	        this.desc = desc;
	    }
	
	public String desc() {
	        return this.desc;
	    }
}
