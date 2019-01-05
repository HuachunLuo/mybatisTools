package com.systexgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.systexgc.entity.Column;

@Mapper
public interface ColumnDao {
	@Select("SELECT  a.name ," + " CASE WHEN COLUMNPROPERTY(a.object_id, a.name, 'IsIdentity') = 1 THEN '1'"
			+ " ELSE '0'" + " END isFlag," + " CASE WHEN UPPER(b.name) = 'CHAR' THEN 'String'"
			+ "  WHEN UPPER(b.name) = 'varchar' THEN 'String'" + "  WHEN UPPER(b.name) = 'numeric' THEN 'Float'"
			+ "  WHEN UPPER(b.name) = 'int' THEN 'Integer'" + "  WHEN UPPER(b.name) = 'date' THEN 'Date'"
			+ "  WHEN UPPER(b.name) = 'datetime' THEN 'Date'" + " END AS Typename" + " FROM    sys.columns a"
			+ " LEFT JOIN sys.types b ON a.system_type_id = b.system_type_id"
			+ " WHERE   OBJECT_ID(#{tableName}) = a.object_id;")
	@Results({ @Result(property = "name", column = "name"), @Result(property = "typename", column = "typename"),
			@Result(property = "isFlag", column = "isFlag") })
	List<Column> getColumns(String tableName);
}
