package com.sode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.Comment;
import com.sode.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repository;
	
	
	
	public List<Comment> findAll(){
		return repository.findAll();
	}
	
	public Comment findById(String id) {
		return repository.findById(id).get();
	}


}
