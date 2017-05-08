package ca.mitx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ca.mitx.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUserName(String userName);
	
	public User findByUserId(Long userId);
	
	//public User findOne(Long usderId);

	@Query(value="select u.USER_ID from blog_user u order by u.USER_ID limit 1", nativeQuery = true)
	public int findFirstUserId();

}
