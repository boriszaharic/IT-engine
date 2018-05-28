package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.web.dto.UserModifyDTO;

@Component
public class UserToUserModifyDTO implements Converter<User, UserModifyDTO> {

	@Override
	public UserModifyDTO convert(User user) {

		UserModifyDTO dto = new UserModifyDTO();
		
		dto.setId(user.getId());
		dto.setFirstname(user.getFirstName());
		dto.setLastname(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setPasswordConfirm(user.getPassword());
		dto.setCompanyId(user.getCompany().getId());
		dto.setCompanyName(user.getCompany().getCompanyName());
		dto.setRole(user.getRoles().toString());
		
		return dto;
	}
	
	public List<UserModifyDTO> convert(List<User> users){
		
		List<UserModifyDTO> dtos=new ArrayList<>();
		
		for (User user : users) {
			dtos.add(convert(user));
		}
		
		return dtos;
		
	}

}
