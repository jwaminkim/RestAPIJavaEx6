package com.mavern.ex6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	@GetMapping(path = "/home")
	public String Get(
		@RequestParam(name="param1", defaultValue="true") String param1,
		@RequestParam(name="param2", defaultValue="false") String param2
		) {

		return "param1: "+param1+", param2: ";
	}
	
	@GetMapping(path = "/home/list")
	public String GetRestAPI() {
		String testval = "test2";
		
		return testval;
	}
}
