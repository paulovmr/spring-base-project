package com.baseproject.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseproject.model.user.User;
import com.baseproject.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody User findUserByUsername(@PathVariable("name") String username) {
		return userService.findUserByUsername(username);
	}
}
