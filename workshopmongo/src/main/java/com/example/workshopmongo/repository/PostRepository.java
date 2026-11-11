package com.example.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(@Param("title") String title);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
