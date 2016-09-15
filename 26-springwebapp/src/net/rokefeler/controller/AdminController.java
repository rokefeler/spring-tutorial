package net.rokefeler.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.rokefeler.pojo.Admin;
import net.rokefeler.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model modelo, 
			@ModelAttribute("resultado") String resultado){
		List<Admin> admins=adminService.findAll();
		modelo.addAttribute("admin", new Admin()); //persiste solo en este controlador
		modelo.addAttribute("resultado",resultado);
		modelo.addAttribute("admins",admins);
		return "admin";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleadmin(@ModelAttribute("admin") Admin adminForm, 
			Model model, 
			RedirectAttributes ra){
	
		if(adminService.save(adminForm)){
			ra.addFlashAttribute("resultado","Cambios realizados con exito"); //persistira en varias peticiones, si se redirige a otros controladores	
		}else{
			ra.addFlashAttribute("resultado","ERROR al realizar los cambios!"); //persistira en varias peticiones, si se redirige a otros controladores
		}
		
		
		return "redirect:/admin"; //retornar una redireccion y ya no una vista
	}
	
	@RequestMapping("/admin/{idAd}/update")
	public String showUpdate(Model model, 
			@PathVariable("idAd") int id){
	
		Admin admin = adminService.findById(id);
		model.addAttribute("admin",admin); //se debe llamar si o si admin, segun vista desea recibir un parametro admin
		return "admin"; 
	}
}
