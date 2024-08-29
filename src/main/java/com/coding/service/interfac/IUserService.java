package com.coding.service.interfac;

import com.coding.dto.LoginRequest;
import com.coding.dto.Response;
import com.coding.entity.User;

public interface IUserService {

	Response register(User user);
	
	Response login(LoginRequest loginRequest);
	
	Response getAllUsers();
	
	Response getUserBookingHistory(String userId);
	
	Response deleteUser(String UserId);
	
	Response getUserById(String userId);
	
	Response getMyInfo(String email);
}
