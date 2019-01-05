package com.systexgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.systexgc.entity.Column;
import com.systexgc.serviceimpl.ColumnImpl;

@RestController
public class columnController {
	
	
	
	@Autowired
	ColumnImpl impl;
	
	
	@RequestMapping(value="/getcolumns",method=RequestMethod.POST)
	public String getColumns(@RequestParam(value="tableName",required=true)String tableName){
		return impl.getColumns(tableName);		
	}
	
	@RequestMapping(value="/getselectstring",method=RequestMethod.POST)
	public String getselectstring(@RequestParam(value="tableName",required=true)String tableName,@RequestParam(value="isresults",required=true)Boolean isresults){
		return impl.getSelectString(tableName,isresults);		
	}
	
	@RequestMapping(value="/getinsertstring",method=RequestMethod.POST)
	public String getinsertstring(@RequestParam(value="tableName",required=true)String tableName,@RequestParam(value="isresults",required=true)Boolean isresults){
		return impl.getInsertString(tableName,isresults);		
	}
	
	@RequestMapping(value="/getdeletestring",method=RequestMethod.POST)
	public String getdeletestring(@RequestParam(value="tableName",required=true)String tableName,@RequestParam(value="isresults",required=true)Boolean isresults){
		return impl.getDeleteString(tableName,isresults);		
	}
	
	@RequestMapping(value="/getupdatestring",method=RequestMethod.POST)
	public String getupdatestring(@RequestParam(value="tableName",required=true)String tableName,@RequestParam(value="isresults",required=true)Boolean isresults){
		return impl.getUpdateString(tableName,isresults);		
	}
}
