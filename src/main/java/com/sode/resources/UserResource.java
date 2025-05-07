package com.sode.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sode.domain.Post;
import com.sode.domain.User;
import com.sode.dto.UserDTO;
import com.sode.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	public UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		return ResponseEntity.ok().body(new UserDTO(service.findById(id)));

	}

	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO usr) {

		UserDTO insertedUser = service.insert(usr);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		UserDTO usr = new UserDTO( service.findById(id) );

		service.delete(usr);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO usr) {
		UserDTO updatedUser = service.update(id, usr);

		return ResponseEntity.ok().body(updatedUser);

	}

	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findAllPosts(@PathVariable String id) {
		return ResponseEntity.ok().body( service.findById(id).getPosts() );

	}

}
