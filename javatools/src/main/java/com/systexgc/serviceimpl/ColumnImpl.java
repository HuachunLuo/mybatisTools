package com.systexgc.serviceimpl;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systexgc.Utils.TypeConvert;
import com.systexgc.dao.ColumnDao;
import com.systexgc.entity.Column;
import com.systexgc.service.ColumnService;

@Service
public class ColumnImpl implements ColumnService {

	@Autowired
	ColumnDao columnDao;

	/***
	 * 作者: RO 日期: 2019年1月5日 下午2:04:29 说明:
	 ***/
	@Override
	public String getColumns(String tableName) {
		List<Column> columns = columnDao.getColumns(tableName);
		String s_return = "";
		for (Column column : columns) {
			String s = String.format("private %s %s;", column.getTypename(), column.getName());
			s_return = s + s_return;
		}

		return s_return;
	}

	/***
	 * 作者: RO 日期: 2019年1月5日 下午2:05:09 说明: 取得@Select语法
	 ***/
	@Override
	public String getSelectString(String tableName, Boolean isresults) {
		List<Column> columns = columnDao.getColumns(tableName);
		String s_return = "";
		String s = "";
		String sresult = "";
		for (Column column : columns) {
			s = s + String.format("%s,", column.getName());

			if (isresults == true) {
				String s_result = String.format("@Result(property = \"%s\",  column = \"%s\"),", column.getName(),
						column.getName());
				sresult = sresult + s_result;
			}
		}
		
		sresult = sresult.substring(0, sresult.length() - 1);
		s = s.substring(0, s.length() - 1);
		s_return = s_return.format("@Select(\"Select %s from %s\")", s, tableName);
		if (isresults == true) {
			s_return = s_return + sresult.format("@Results({%s}) ", sresult);
		}
		return s_return;
	}

	@Override
	public String getUpdateString(String tableName, Boolean isresults) {
		List<Column> columns = columnDao.getColumns(tableName);
		String s_return = "";
		String s = "";
		String sflag = "";
		String sresult = "";
		for (Column column : columns) {
			if (column.getIsFlag() == 0) {
				s = s + String.format("%s=#{%s},", column.getName(), column.getName());
			}

			if (column.getIsFlag() == 1) {
				sflag = sflag.format(" %s=#{%s}", column.getName(), column.getName());
			}

			if (isresults == true) {
				String s_result = String.format("@Result(property = \"%s\",  column = \"%s\"),", column.getName(),
						column.getName());
				sresult = sresult + s_result;
			}
		}
		sresult = sresult.substring(0, sresult.length() - 1);
		s = s.substring(0, s.length() - 1);
		s_return = s_return.format("@Update(\"Update %s Set %s where %s\")", tableName, s, sflag);
		if (isresults == true) {
			s_return = s_return + sresult.format("@Results({%s}) public int update(%s %s);", sresult,tableName,String.format("%s", tableName));
		}
		return s_return;
	}

	@Override
	public String getDeleteString(String tableName, Boolean isresults) {
		List<Column> columns = columnDao.getColumns(tableName);
		String s_return = "";
		String s = "";
		String sflag = "";
		for (Column column : columns) {
			if (column.getIsFlag() == 1) {
				sflag = sflag.format(" Where %s=#{%s}", column.getName(), column.getName());
			}
		}
		s_return = s_return.format("@Delete(\"Delete %s %s\") public int delete();", tableName, sflag);
		return s_return;
	}

	@Override
	public String getInsertString(String tableName, Boolean isresults) {
		List<Column> columns = columnDao.getColumns(tableName);
		String s_return = "";
		String svalue = "";
		String sname = "";
		String sresult = "";
		for (Column column : columns) {
			svalue = svalue + String.format("#{%s},", column.getName());
			sname = sname + String.format("%s,", column.getName());

			if (isresults == true) {
				String s_result = String.format("@Result(property = \"%s\",  column = \"%s\"),", column.getName(),
						column.getName());
				sresult = sresult + s_result;
			}
		}
		sresult = sresult.substring(0, sresult.length() - 1);
		svalue = svalue.substring(0, svalue.length() - 1);
		sname = sname.substring(0, sname.length() - 1);
		s_return = s_return.format("@Insert(\"insert into %s(%s) values(%s)\")", tableName, sname, svalue);
		if (isresults == true) {
			s_return = s_return + sresult.format("@Results({%s}) public int insert(%s %s);", sresult,tableName,String.format("%s", tableName));
		}
		return s_return;
	}

}
