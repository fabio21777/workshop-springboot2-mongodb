package com.fsm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.domain.Post;
import com.fsm.repository.PostRepository;
import com.fsm.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	public Post findById(String id) {
		Optional<Post> Post = postRepository.findById(id);
		return Post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
