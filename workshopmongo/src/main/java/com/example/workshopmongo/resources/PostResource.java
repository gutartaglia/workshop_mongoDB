package com.example.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.services.PostService;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping (value = "/posts") 
public class PostResource {

    @Autowired 
    private PostService service;

    public PostResource(PostService service){
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable  String id) {
        Post post = service.findByIdPost(id);
        return ResponseEntity.ok().body(post);
    }
    
    
}
