package com.tienda.mintic.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class appcontroller {
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";	
	}
	@GetMapping({"/usuarios"})
	public String usuarios() {
		return "usuarios";	
		
	}
	@GetMapping({"/logout"})
		public String logout() {
			return "logout";	
	}
	@RequestMapping("validar2")
	public String validar(HttpServletRequest req,HttpServletRequest resp) {

		String usuariot=req.getParameter("usuariot");
		String password=req.getParameter("password");
		if(usuariot.equals("admin") && password.equals("admin123456")){
			 return "menu";
		
		}else {
			return "error";
		}
		
		
	}
		

	
}
