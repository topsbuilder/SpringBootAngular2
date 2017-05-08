package ca.mitx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mitx.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
	
//	@Query("from Post as post where post.content = ?1 and post.user.userId = ?2")
//	public Post findByContentAndUser_UserId(String content, Long userId);
	
	public List<Post> findByUser_UserId(Long userId);

	public List<Post> findByContentAndUser_UserId(String content, Long userId);
	
}
