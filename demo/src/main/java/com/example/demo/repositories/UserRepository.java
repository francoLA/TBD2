package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    User findUserById(Long id);
}
