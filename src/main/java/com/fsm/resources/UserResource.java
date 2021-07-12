package com.fsm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.domain.Post;
import com.fsm.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class UserResource {
	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}

}
