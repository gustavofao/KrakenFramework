package com.kraken.model;

public class CacheItem {
	private String value;
	private Integer type;
	private String tag;
	
	public CacheItem(String value, String tag, int type){
		this.value = value;
		this.tag = tag;
		this.type = type;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getTag(){
		return tag;
	}
	
	public Integer getType(){
		return type;
	}

}
