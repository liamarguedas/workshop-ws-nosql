package com.sode.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

}
