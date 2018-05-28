package com.example.demo.support;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Company;
import com.example.demo.web.dto.CompanyDTO;

@Component
public class CompanyToCompanyDTO implements Converter<Company, CompanyDTO> {

	@Override
	public CompanyDTO convert(Company company) {

		CompanyDTO dto = new CompanyDTO();

		dto.setId(company.getId());

		dto.setName(company.getCompanyName());

		dto.setAddress(company.getCompanyAddress());

		dto.setContactPerson(company.getContactPerson());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		dto.setLicenceTill(sdf.format(company.getLicenceTill()));

		return dto;
	}

	public List<CompanyDTO> convert(List<Company> companies) {

		List<CompanyDTO> dtos = new ArrayList<>();

		for (Company company : companies) {
			dtos.add(convert(company));
		}

		return dtos;
	}

}