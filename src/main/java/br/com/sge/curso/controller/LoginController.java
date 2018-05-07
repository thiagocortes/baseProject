package br.com.sge.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(@RequestParam String usuario, @RequestParam String senha) {
		
		return "success";
	}

}
