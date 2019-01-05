package com.systexgc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systexgc.dao.TablesDao;
import com.systexgc.entity.Tables;
import com.systexgc.service.TablesService;

@Service
public class TablesImpl implements TablesService {

	@Autowired
	private TablesDao dao;
	
	@Override
	public List<Tables> getTables() {
		return dao.getTables();
	}

}
