package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Company;

public interface CompanyService {

	Page<Company> findAll(int pageNum);

	Company findOne(Long id);

	void save(Company company);

	void remove(Long id);
}