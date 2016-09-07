package net.rokefeler.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.rokefeler.pojo.Admin;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String showAdmin(Model modelo){
		modelo.addAttribute("admin", new Admin()); //persiste solo en este controlador
		return "admin";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleadmin(@ModelAttribute("admin") Admin adminForm, Model model){
		adminForm.setFechacreacion( new Timestamp(new Date().getTime()));
		model.addAttribute("adminForm", adminForm);
		
		return "index"; //retornar vista index
	}
}
