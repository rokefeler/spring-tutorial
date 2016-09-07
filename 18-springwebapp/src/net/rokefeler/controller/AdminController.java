package net.rokefeler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.rokefeler.pojo.Admin;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String showAdmin(Model modelo){
		Admin admin=new Admin();
		
		modelo.addAttribute("admin", admin); //persiste solo en este controlador
		return "admin";
	}
}
