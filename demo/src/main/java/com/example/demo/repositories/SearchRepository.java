package com.example.demo.repositories;

import com.example.demo.models.Twitt;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends ElasticsearchRepository<Twitt, Long> {
    List<Twitt> findByText(String text);
    Iterable<Twitt> findByUserName(String user);
}
