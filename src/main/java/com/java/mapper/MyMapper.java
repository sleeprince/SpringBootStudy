package com.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface MyMapper {
	
	@Select("select 1 as no")
	public int test();
	
	@Select("<script>"
			+ "select * from temp1 "
			+ "<if test='accept==0'>where accept = 0</if>"
			+ "<if test='accept==1'>where accept = 1</if>"
			+ "</script>")
	public List<Map> findList(Object accept);
	
	@Select("select * from temp1 where no = #{no}")
	public Map findOne(int no);
	
	@SelectKey(statement="select last_insert_id() as no", 
			keyProperty="no",
			before=false,
			resultType=int.class)
	@Insert("insert into temp1 (title, content) value (#{title}, #{content})")
	public int insert(Map map);
}
