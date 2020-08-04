package br.com.devmedia.curso.web.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.curso.dao.UsuarioDao;
import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;

/*o atributo value esta oculto no metodo. Boa pratica nomear controllers
nome da app/usuario */

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao dao;

	/*
	 * O getLista através do addAttribute, irá popular a variavel "usuarios" que é a
	 * mesma indicada no forEach do lista.jsp
	 * A model enviará os dados populados da variavel "usuario" e entrega para a
     * lista.jsp
	 */
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("usuarios", dao.getLista());
		return new ModelAndView("/user/lista", model);
	}

 	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
 		model.addAttribute("sexos", TipoSexo.values());
		return "/user/adcionar";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "/user/adcionar";
		}
		
		dao.salvar(usuario);
		attributes.addFlashAttribute("message", "Cadastro efetuado com sucesso!");
		System.out.println("Objeto Salvo!");
		return "redirect:/usuario/todos";
	}
	
	/**
	 * Classe usuario controller que irá localizar o usuario. 
	 * O metodo préupdade como forma de preparação para atualização. Por isso * possui o nome de pré no mome. 
	 * @PathVariable("id") - Sera o resposavel por levar o paramentro da url 
	 * no id do tipo Long id, ModelMap model
	 * O objeto usuario sera populado pelo metodo do dao dao.getid(id)
	 * E o ModelMap map se encarregara de levar esse objeto ate a jsp. 
	 **/
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		
		Usuario usuario = dao.getId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/adcionar", model);
	}

	/**
	* Esse sera o metodo que realmente fara alteracao
	 **/
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/user/adcionar");
		}
		dao.editar(usuario);
		attr.addFlashAttribute("message", "Usuario Alterado com sucesso!");
		System.out.println("Objeto Alterado");
		return new ModelAndView("redirect:/usuario/todos");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@ModelAttribute("id") Long id, RedirectAttributes attr) {
		dao.excluir(id);
		attr.addFlashAttribute("message", "Usuario Excluido com sucesso!");
		System.out.println("Objeto Excluido");
		return new ModelAndView("redirect:/usuario/todos");
	}
}
