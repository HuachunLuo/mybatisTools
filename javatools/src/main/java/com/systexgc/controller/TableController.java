package com.systexgc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systexgc.entity.Tables;
import com.systexgc.serviceimpl.TablesImpl;

@RestController
public class TableController {

	@Autowired
	TablesImpl tablesimpl;
	
	@RequestMapping("/gettables")
	public List<Tables> getTables(){
//			List<String> list = new ArrayList<String>();
//			
//			
//			list.add("12");
//			list.add("wwww");
		
		return tablesimpl.getTables();
	}
}
