package com.sts.beans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.beans.models.Users;
import com.sts.beans.repository.UsersRepository;
import com.sts.beans.util.JsonResponse;

@RestController()
@RequestMapping(value = "/users", produces = "application/json")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	@RequestMapping(value = "/")
	public String getAllUsers() {
		JsonResponse<Object> jsonResponse = new JsonResponse<Object>("ok", "APi Working Fine", null);
		try {
			List<Users> users = usersRepository.getAllUsers();
			jsonResponse.setData(users);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResponse.setMessage(e.getMessage());
		}
		return jsonResponse.convertToJSON();
	}

	@RequestMapping(value = "/get/byemail/{email:.+}")
	public String getUsersByEmail(@PathVariable String email) {
		JsonResponse<Object> jsonResponse = new JsonResponse<Object>("ok", "APi Working Fine", null);
		try {
			Users users = usersRepository.getUserByEmail(email);
			jsonResponse.setData(users);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResponse.setMessage(e.getMessage());
		}
		return jsonResponse.convertToJSON();
	}

}
