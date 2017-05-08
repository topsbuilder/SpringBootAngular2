package ca.mitx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mitx.entity.User;
import ca.mitx.repository.UserRepository;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	
	public User findByUserName(String userName){
		return this.userRepository.findByUserName(userName);
	}
	
	public User findByUserId(Long userId){
//		Object o = this.userRepository.findOne(userId);
//		return this.userRepository.findByUserId(userId);
		//return this.userRepository.findOne(userId);
		return null;
	}

}
