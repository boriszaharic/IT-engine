package com.example.demo.service;

import org.springframework.data.domain.Page;
import com.example.demo.entities.User;

public interface UserService {

	Page<User> findAll(int pageNum);

	User findOne(Long id);

	void save(User user);

	void remove(Long id);

	Page<User> findByCompanyId(int pageNum, Long companyId);
}
