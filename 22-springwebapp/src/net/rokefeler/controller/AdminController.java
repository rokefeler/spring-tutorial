package net.rokefeler.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.rokefeler.pojo.Admin;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String showAdmin(Model modelo, 
			@ModelAttribute("resultado") String resultado){
		modelo.addAttribute("admin", new Admin()); //persiste solo en este controlador
		modelo.addAttribute("resultado",resultado);
		return "admin";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleadmin(@ModelAttribute("admin") Admin adminForm, 
			Model model, 
			RedirectAttributes ra,
			@RequestParam("estado") String estado){
		//accion=activa?id=1 este es un RequestParam
		adminForm.setFechacreacion( new Timestamp(new Date().getTime()));
		model.addAttribute("adminForm", adminForm);
		System.out.println(adminForm);
		System.out.println("RequestParam estado:"+estado);
		ra.addFlashAttribute("resultado","Cambios realizados con exito	"); //persistira en varias peticiones, si se redirige a otros controladores
		
		return "redirect:/admin"; //retornar una redireccion y ya no una vista
	}
}
