package com.sode.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
