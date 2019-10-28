package com.panda.ribbon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panda.ribbon.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

    @GetMapping(value = "/user/findAll")
    public Map findAll() {
        return userService.findAll();
    }
	
}
