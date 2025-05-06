package com.sode.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sode.domain.Comment;
import com.sode.services.CommentService;

@RestController
@RequestMapping(value="/comments")
public class CommentResource {

	@Autowired
	private CommentService service;
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Comment> findById(@PathVariable String id){
		return ResponseEntity.ok().body(service.findById(id));
	}
}
