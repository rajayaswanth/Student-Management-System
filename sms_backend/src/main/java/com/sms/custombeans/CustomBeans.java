package com.sms.custombeans;

import java.util.function.Function;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sms.dto.responses.UserResponse;
import com.sms.entities.User;
import com.sms.repositories.UserRepository;
import com.sms.utils.UserUtilService;

@Aspect
@Component
public class CustomBeans {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserUtilService userUtil;

	@Bean
	public Function<UserDetails, UserResponse> fetchUser() {
		return (principal -> {
			String name = principal.getUsername();
			User user = userRepo.findByEmail(name);
			UserResponse reponse = userUtil.convertUserToUserResponse(user);
			return (user != null) ? reponse : null;
		});
	}

}
