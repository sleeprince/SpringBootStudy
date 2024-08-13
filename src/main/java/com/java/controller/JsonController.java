package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.FileDTO;
import com.java.dto.JsonDTO;
import com.java.mapper.JsonMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/json")
public class JsonController {

	private final JsonMapper jsonMapper;
	private int KEY = 5;
	
//	@GetMapping("/test")
//	public JsonDTO test() {
//		JsonDTO jsonDto = JsonDTO.builder().build();
//		int no = jsonMapper.test(KEY);
//		if(KEY == no) {
//			Map map = new HashMap<>();
//			map.put("no", no);
//			jsonDto.setResult(map);
//			jsonDto.setMessage("데이터베이스 접속 성공");
//			jsonDto.setStatus(true);
//		} else {
//			jsonDto.setMessage("데이터베이스 접속 실패");
//			jsonDto.setStatus(false);
//		}
//		return jsonDto;
//	}
	
	@GetMapping("/type/{type:[0-9]+}")
	public JsonDTO type(@PathVariable("type") int type) {
		JsonDTO jsonDTO = JsonDTO.builder().build();
		jsonDTO.setMessage("파일 목록 실패");
		jsonDTO.setStatus(false);
		
		List<FileDTO> list = jsonMapper.getFiles(type);
		System.out.println(list.toString());
		if(list.size() > 0) {
			jsonDTO.setResult(list);
			jsonDTO.setMessage("파일 목록 성공");
			jsonDTO.setStatus(true);
		}		
		return jsonDTO;
	}
//	
//	@GetMapping("/no/{no}/type/{type}")
//	public JsonDTO delete(@PathVariable("no") int no, int type) {
//		JsonDTO jsonDTO = JsonDTO.builder().build();
//		jsonDTO.setMessage("파일 삭제 실패");
//		jsonDTO.setStatus(false);
//		
//		if(jsonMapper.delete(no) == 1) {
//			List<FileDTO> list = jsonMapper.getFiles(type);
//			jsonDTO.setResult(list);
//			jsonDTO.setMessage("파일 삭제 성공");
//			jsonDTO.setStatus(true);
//		}
//		return jsonDTO;
//	}
	
	@GetMapping("/no/{no}/type/{type}")
	public JsonDTO getMethodName(@PathVariable("no") int no, @PathVariable("type") int type) {
		JsonDTO jsonDTO = JsonDTO.builder().build();
		jsonDTO.setMessage("파일 갱신 실패");
		jsonDTO.setStatus(false);
		
		if(jsonMapper.update(no) == 1) {
			List<FileDTO> list = jsonMapper.getFiles(type);
			jsonDTO.setResult(list);
			jsonDTO.setMessage("파일 갱신 성공");
			jsonDTO.setStatus(true);
		}
		return jsonDTO;
	}
	
}
