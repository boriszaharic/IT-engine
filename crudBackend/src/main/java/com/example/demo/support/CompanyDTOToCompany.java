package com.example.demo.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Company;
import com.example.demo.service.CompanyService;
import com.example.demo.web.dto.CompanyDTO;

@Component
public class CompanyDTOToCompany implements Converter<CompanyDTO, Company> {

	@Autowired
	CompanyService companyService;

	@Override
	public Company convert(CompanyDTO dto) {

		Company company = new Company();

		if (dto.getId() != null) {
			company = companyService.findOne(dto.getId());

			if (company == null) {
				throw new IllegalStateException("Tried to modify a non-existant company");
			}
		}

		company.setId(dto.getId());
		company.setCompanyName(dto.getName());
		company.setCompanyAddress(dto.getAddress());
		company.setContactPerson(dto.getContactPerson());

		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String licenceTill = dto.getLicenceTill();
		try {
			date = sdf.parse(licenceTill);
		} catch (ParseException e) {
			System.out.println("Exception occured during recording of date!");
			e.printStackTrace();
		}

		if (licenceTill != null)
			company.setLicenceTill(licenceTill);

		return company;
	}

	public List<Company> convert(List<CompanyDTO> dtos) {

		List<Company> companies = new ArrayList<>();

		for (CompanyDTO dto : dtos) {
			companies.add(convert(dto));
		}

		return companies;

	}

}