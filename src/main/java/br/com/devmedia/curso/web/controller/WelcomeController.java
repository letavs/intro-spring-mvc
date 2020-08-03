package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String welcome() {
		//return "welcome";
	return "redirect:/usuario/todos"; // O redirect e feito a partir do Controller
	}
	
	@RequestMapping(value ="/teste", method = RequestMethod.GET)
	public ModelAndView teste () {
		ModelAndView view= new ModelAndView("welcome");
		view.addObject("teste", "Ola, eu sou Spring MVC");
		return view;
	}
}
