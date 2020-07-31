package br.com.devmedia.curso.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.curso.dao.UsuarioDao;

//o atributo value esta oculto no metodo. Boa pratica nomear controllers
//nome da app/usuario
@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao dao;
	
	@RequestMapping(value ="/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("usuarios", dao.getLista());
		return new ModelAndView("/user/lista", model); // A model irá enviar os dados populados da lista. e enviará para a lista.jsp
	}
}
