package com.wisenut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
}