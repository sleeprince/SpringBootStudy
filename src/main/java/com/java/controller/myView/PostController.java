package com.java.controller.myView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mapper.MyMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/myView")
@RequiredArgsConstructor
public class PostController {
	
	final private MyMapper myMapper;
	
	@PostMapping(value = {"/findList", "/findList/{accept:[0:1]}"})
	public List<Map> findList(@PathVariable(name="accept", required=false) Object accept){
		return myMapper.findList(accept);
	}
	
	@PostMapping("/new/{title}/{content}")
	public Map save(@PathVariable("title") String title, @PathVariable("content") String content) {
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		System.out.println(map.toString());
		myMapper.insert(map);
		return map;
	}
	
	@PostMapping("detail/{no:[0:9]+}")
	public Map detail(@PathVariable("no") int no) {
		System.out.println(no);
		return myMapper.findOne(no);
	}
	
	
}
