package com.example.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Company;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.service.CompanyService;

@Service
@Transactional
public class JpaCompanyService implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Page<Company> findAll(int pageNum) {

		return companyRepository.findAll(PageRequest.of(pageNum, 5));
	}

	@Override
	public Company findOne(Long id) {

		return companyRepository.getOne(id);
	}

	@Override
	public void save(Company company) {

		companyRepository.save(company);

	}

	@Override
	public void remove(Long id) {

		companyRepository.deleteById(id);

	}

}
