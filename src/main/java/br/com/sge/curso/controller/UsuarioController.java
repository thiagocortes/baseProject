package br.com.sge.curso.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sge.curso.domain.Usuario;
import br.com.sge.curso.service.UsuarioService;
import br.com.sge.curso.util.Mensagem;
import br.com.sge.curso.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/usuario")
public class UsuarioController{
	
	private static final String URL_FORM = "usuario/form"; 
	private static final String URL_LIST = "usuario/login"; 
	private static final String KEY_ATTR = "usuario"; 
	private static final String KEY_MSG = "mensagem"; 
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		Map<String, Object> map = new HashMap<>();
		map.put(KEY_ATTR, new Usuario());
	}
	
	@RequestMapping(value = "/novo")
	public String novo(Map<String, Object> map) {
		map.put(KEY_ATTR, new Usuario());
		return URL_FORM;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@Valid @ModelAttribute(KEY_ATTR) Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if(usuario.getEmail() != null || usuario.getSenha() != null) {
			attr.addFlashAttribute(KEY_MSG, new Mensagem("Usuário e/ou senha inválidos", TipoMensagem.ERRO));
			return URL_FORM;
		}
		usuarioService.login(usuario.getEmail(), usuario.getSenha());
		return "redirect:/";
	}

	@PostMapping(value = "/salvar")
	public String salvar(@Valid @ModelAttribute(KEY_ATTR) Usuario usuario, BindingResult result, RedirectAttributes attr ) {
		if(result.hasErrors()) {
			return URL_FORM;
		}else {
			usuarioService.salvar(usuario);
			attr.addFlashAttribute(KEY_MSG, new Mensagem("Salvo com sucesso!", TipoMensagem.SUCESSO));
			return "redirect:/"+URL_LIST;
		}
	}


}
