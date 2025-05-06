package com.sode.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sode.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
