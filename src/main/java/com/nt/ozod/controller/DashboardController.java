package com.nt.ozod.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.nt.ozod.controller.util.JsonUtil;
import com.nt.ozod.feign.UserFeign;


@CrossOrigin("*")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private JsonUtil jsonutill;
	
	@Autowired
	private UserFeign userFeign;

	@GetMapping("/header")
	public ResponseEntity<JsonNode> getHeader() throws StreamReadException, DatabindException, IOException {
		return new ResponseEntity<JsonNode>(jsonutill.getHeaderFooterJson().get("header"), HttpStatus.OK);
	}
	
	@GetMapping("/footer")
	public ResponseEntity<JsonNode> getFooter() throws StreamReadException, DatabindException, IOException {
		return new ResponseEntity<JsonNode>(jsonutill.getHeaderFooterJson().get("footer"), HttpStatus.OK);
	}
	
	//Feign Calling
	@GetMapping("/msg")
	public ResponseEntity<String> getMsgFromUser() {
		return new ResponseEntity<String>(userFeign.msg(), HttpStatus.OK);
	}
}
