package com.java.controller.myView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/myView")
@Controller
public class GetController {
	
	@GetMapping("/findList")
	public String findList() {	
		return "myView/list";
	}
	
	@GetMapping("/detail/{no:[0:9]+}")
	public String detail() {
		return "myView/detail";
	}
	
	@GetMapping("/new")
	public String insertNew() {
		return "myView/new";
	}
}
