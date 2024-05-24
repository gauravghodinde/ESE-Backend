package com.ese.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.email.demo.model.emailll;
import com.email.demo.service.emailservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController2 {
	@Autowired
	private emailservice emailServ;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute emailll email,HttpSession session) {
		emailServ.sendMail(email);
		session.setAttribute("msg", "email sent successfully");
		return "redirect:/";
		
	}

}
