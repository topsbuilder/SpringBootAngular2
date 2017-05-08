package ca.mitx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mitx.entity.Post;
import ca.mitx.repository.PostRepository;

@Service
public class PostService {

	@Autowired private PostRepository postRepository;
	
	public List<Post> findByUser_UserId(Long userId){
		return this.postRepository.findByUser_UserId(userId);
	}
}
