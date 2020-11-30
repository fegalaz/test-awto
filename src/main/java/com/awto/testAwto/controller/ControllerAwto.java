package com.awto.testAwto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awto.testAwto.dto.AwHashtag;
import com.awto.testAwto.dto.AwLog;
import com.awto.testAwto.repositories.entity.AwHashtagLogModel;
import com.awto.testAwto.repositories.responds.RespondLog;
import com.awto.testAwto.service.AwtoService;

@RestController
@Validated
@RequestMapping(value ="/api/v1")
public class ControllerAwto {

	@Autowired
	private AwtoService service;
	
	@PostMapping(value ="/logs")
	public ResponseEntity<?> createLog(@RequestBody AwLog awReq){
		Boolean response = service.createLog(awReq);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/logs/hashtag/{id}")
	public ResponseEntity<List<RespondLog>> findById(@PathVariable("id") Integer id){
		List<RespondLog> response = service.findById(id);
		
		return new ResponseEntity<List<RespondLog>>(response, HttpStatus.OK);

	}
	
	@GetMapping(value="/logs/hashtagg/{id}")
	public ResponseEntity<List<AwHashtagLogModel>> buscar(@PathVariable("id") Integer id){
		List<AwHashtagLogModel> response = service.findByHashTagId(id);
		
		return new ResponseEntity<List<AwHashtagLogModel>>(response, HttpStatus.OK);

	}
	
	@PutMapping(value="/hashtags")
	public ResponseEntity<Boolean> updateHashTag(@RequestBody AwHashtag awReq){
		Boolean response = service.updateHashTag(awReq);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}
	
}
