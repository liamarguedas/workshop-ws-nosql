package com.sode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sode.domain.User;
import com.sode.dto.UserDTO;
import com.sode.repositories.UserRepository;
import com.sode.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<UserDTO> list = repository.findAll().stream().map(u -> new UserDTO(u)).toList();
		return list;
	}

	public UserDTO findById(String id) {
		
		User usr = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		
		return new UserDTO(usr);

	}

}
