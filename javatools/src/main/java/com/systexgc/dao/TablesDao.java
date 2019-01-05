package com.systexgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.systexgc.entity.Tables;

@Mapper
public interface TablesDao {
	@Select("SELECT name,object_id FROM sys.tables WHERE type='U'")
	@Results({
        @Result(property = "name",  column = "name"),
        @Result(property = "id", column = "object_id")
    })
	List<Tables> getTables();
}
