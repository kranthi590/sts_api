package com.sts.beans.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.beans.util.JsonResponse;

@RestController
public class RootController {

	@RequestMapping(value = "/", produces = "application/json")
	public String home() {
		JsonResponse<Object> jsonResponse = new JsonResponse<Object>("ok", "APi Working Fine", null);
		try {
			jsonResponse.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return jsonResponse.convertToJSON();
	}
}
