package com.sode.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sode.domain.Comment;
import com.sode.domain.Post;
import com.sode.domain.User;
import com.sode.dto.AuthorDTO;
import com.sode.repositories.CommentRepository;
import com.sode.repositories.PostRepository;
import com.sode.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();
		commentRepository.deleteAll();

		// User test
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		// Post test

		Post p1 = new Post(null, new AuthorDTO(u1), Instant.now(), "Partiu viagem!", "Vou viajar para SP, abraçõs");
		Post p2 = new Post(null, new AuthorDTO(u1), Instant.now(), "Bom dia!", "Acordei feliz!");

		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().add(p1);
		u1.getPosts().add(p2);
		
		userRepository.save(u1);

		Comment c1 = new Comment(null, p1, "Muito bom!", Instant.now());
		Comment c2 = new Comment(null, p2, "Bom dia demais!", Instant.now());
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		commentRepository.saveAll(Arrays.asList(c1,c2));
	}

}
