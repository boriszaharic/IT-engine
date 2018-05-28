package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.web.dto.UserDTO;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

	@Override
	public UserDTO convert(User user) {

		UserDTO dto = new UserDTO();

		dto.setId(user.getId());

		dto.setFirstName(user.getFirstName());

		dto.setLastName(user.getLastName());

		dto.setEmail(user.getEmail());
		if (user.getCompany() != null) {
			dto.setCompanyId(user.getCompany().getId());

			dto.setCompanyName(user.getCompany().getCompanyName());
		}else {
			dto.setCompanyId(0L);
			dto.setCompanyName("SUPER_ADMIN");
		}

		return dto;
	}

	public List<UserDTO> convert(List<User> users) {

		List<UserDTO> dtos = new ArrayList<>();

		for (User user : users) {
			dtos.add(convert(user));
		}

		return dtos;

	}

}