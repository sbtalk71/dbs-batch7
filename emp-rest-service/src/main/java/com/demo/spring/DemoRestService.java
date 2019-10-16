package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestService {

	//@RequestMapping(path = "/greet/{n}", method = RequestMethod.GET)
	@GetMapping(path="/greet/{n}")
	public ResponseEntity<String> greet(@PathVariable("n")String name) {
		return ResponseEntity.ok(" Dear, "+name+ " Hello From Spring REST");
	}
}
