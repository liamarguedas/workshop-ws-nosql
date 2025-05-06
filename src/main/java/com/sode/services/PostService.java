package com.sode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.Post;
import com.sode.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		return repository.findById(id).get();
	}

}
