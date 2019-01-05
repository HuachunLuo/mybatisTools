package com.systexgc.Utils;

import java.util.HashMap;
import java.util.Map;

public class TypeConvert {

	private Map<String, String> map;
	
	private static TypeConvert instance=null;
	
	private TypeConvert() {
		super();
		map = new  HashMap<String, String>();
		map.put("datetime", "Date");
		map.put("varchar", "String");
		map.put("char", "String");
		map.put("int", "Integer");
		map.put("decimal", "Float");
		map.put("numeric", "Float");
	}

	public static TypeConvert getInstance(){
		return instance;
	}
	
	public String getValue(String keyName){
		return map.get(keyName);
	}
	
}
