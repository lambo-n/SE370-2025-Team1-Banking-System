package com.se370group1.banking_system.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.se370group1.banking_system.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    List<User> findByUserID(String userID);
}
