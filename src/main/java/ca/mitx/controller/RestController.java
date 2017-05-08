package ca.mitx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.mitx.entity.Post;
import ca.mitx.entity.User;
import ca.mitx.repository.PostRepository;
import ca.mitx.repository.UserRepository;

@org.springframework.web.bind.annotation.RestController
//@RequestMapping("/api")
public class RestController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;	

	@RequestMapping("/")
	public String demo() {
		return "Hi";
	}
	
	@RequestMapping("/api/hello/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Hello " + name;
	}

	@RequestMapping("/api/findFirstUserId")
	public int findFirstUserId() {
		return this.userRepository.findFirstUserId();
	}
	
	@RequestMapping("/api/findByUserName/{userName}")
	public User getNameById(@PathVariable("userName") String userName) {
		System.err.println(userName);
		User user = this.userRepository.findByUserName(userName);
		System.err.println("user=" + user.toString());
		return user;
	}

	@RequestMapping("/api/findByContentAndUserId/{content}/{userId}")
	public List<Post> findByContentAndUserId(@PathVariable("content") String content, @PathVariable("userId") Long userId) {
		List<Post> posts = this.postRepository.findByContentAndUser_UserId(content, userId);
		return posts;
	}
	
	@RequestMapping("/api/findByPostsContent/{userId}")
	public List<Post> findByPostsContent(@PathVariable("userId") Long userId) {
		List<Post> posts = this.postRepository.findByUser_UserId(userId);
		return posts;
	}
	
	@RequestMapping("/api/findByUserId/{userId}")
	public List<Post> findByUserId(@PathVariable("userId") Long userId) {
		User user = this.userRepository.findByUserId(userId);
		return user.getPosts();
	}
	
	@RequestMapping(value="/api/updatePost/", method=RequestMethod.PUT)
	public Post updatePostsById(@RequestBody Post post) {
		Post post1 = this.postRepository.save(post);
		return post1;
	}
}