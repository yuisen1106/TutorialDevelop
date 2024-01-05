package com.techacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;


	public UserService(UserRepository repository) {
		this.userRepository=repository;
	}
	/**全件を検索して返す*/
	public List<User> getUserList(){
		return userRepository.findAll();

	}

	/**Userの登録を行う*/
	@Transactional
	public User saveUser(User user) {
	return userRepository.save(user);
	}


}
