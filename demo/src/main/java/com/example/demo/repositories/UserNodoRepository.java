package com.example.demo.repositories;

import com.example.demo.models.User;
import com.example.demo.models.UserNodo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "User", path = "User")
@Repository
public interface UserNodoRepository extends Neo4jRepository<User, Long> {

    UserNodo findByUserId(@Param("userID") Long userID);
}
