package net.rokefeler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//@SessionAttributes({"resultado","mensaje"}) //este atributo sera visible en todos los controladores
@SessionAttributes("resultado") 
public class IndexController {
	
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("resultado", "Resultado desde Session");
		return "index";
	}
//	public String showIndex(HttpSession session){ //se puede hacer asi, pero utilizaremos @SessionAttribute
//		session.setAttribute("resultado", "Resultado desde Session");
//		return "index";
//	}
	
	@RequestMapping("/about")
	public String showAbout(SessionStatus status){
		status.setComplete(); //Limpia todos los atributos solo para este controlador
		return "about";
	}
	
	
}
