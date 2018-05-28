package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;

@Service
public class JpaUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findAll(int pageNum) {

		return userRepository.findAll(PageRequest.of(pageNum, 10));
	}

	@Override
	public User findOne(Long id) {

		return userRepository.getOne(id);
	}

	@Override
	public void save(User user) {

		userRepository.save(user);

	}

	@Override
	public void remove(Long id) {

		userRepository.deleteById(id);

	}

	@Override
	public Page<User> findByCompanyId(int pageNum, Long companyId) {
		
		return userRepository.findByCompanyId((PageRequest.of(pageNum, 10)),companyId);
	}

}