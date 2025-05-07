package com.sode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sode.domain.User;
import com.sode.dto.UserDTO;
import com.sode.repositories.UserRepository;
import com.sode.services.exception.DataIntegrityViolationException;
import com.sode.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User fromDTO(UserDTO usr) {
		return new User(usr.getId(), usr.getName(), usr.getEmail());

	}

	public List<UserDTO> findAll() {
		List<UserDTO> list = repository.findAll().stream().map(u -> new UserDTO(u)).toList();
		return list;
	}

	public UserDTO findById(String id) {

		User usr = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));

		return new UserDTO(usr);
	}

	public UserDTO insert(UserDTO usr) {
		return new UserDTO(repository.insert(fromDTO(usr)));
	}

	public void delete(UserDTO usr) {
		try {
			repository.delete(fromDTO(usr));
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Integrity constrain violation.");
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Object not found");
		}
	}

	public UserDTO update(String id, UserDTO updatedUsr) {
		
		User storedUsr = fromDTO(findById(id));
		updateUser(storedUsr, fromDTO(updatedUsr));
		
		return new UserDTO(repository.save(storedUsr));
		
	}
	
	private void updateUser(User storedUsr, User updatedUsr) {
		storedUsr.setName(updatedUsr.getName());
		storedUsr.setEmail(updatedUsr.getEmail());
	}
	
	
	
	
}
