package com.systexgc.service;

import java.util.List;

import com.systexgc.entity.Column;

public interface ColumnService {
	public String getColumns(String tableName);
	public String getSelectString(String tableName,Boolean isresults);
	public String getUpdateString(String tableName,Boolean isresults);
	public String getDeleteString(String tableName,Boolean isresults);
	public String getInsertString(String tableName,Boolean isresults);
}
