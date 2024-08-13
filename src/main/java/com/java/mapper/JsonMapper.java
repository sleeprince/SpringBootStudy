package com.java.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java.dto.FileDTO;

@Mapper
public interface JsonMapper {

	@Select("select #{no} as no")
	public int test(int no);
	
	@Select("select * from files where type = ${type} and del = 0")
	public List<FileDTO> getFiles(int type);
	
	@Update("update files set del = 1 where no = ${no}")
	public int delete(int no);
	
	@Update("update files set cnt = cnt + 1 where no =${no}")
	public int update(int no);
}
