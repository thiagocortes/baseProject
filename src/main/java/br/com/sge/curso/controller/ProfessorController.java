package br.com.sge.curso.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sge.curso.converter.DateConverter;
import br.com.sge.curso.domain.Professor;
import br.com.sge.curso.domain.TipoSexo;
import br.com.sge.curso.service.ProfessorService;
import br.com.sge.curso.util.Mensagem;
import br.com.sge.curso.util.Mensagem.TipoMensagem;

@RestController
@RequestMapping("/professor")
public class ProfessorController extends BaseController<Professor, Long>{
	
	private static final String URL_FORM = "professor/form"; 
	private static final String URL_LIST = "professor/list"; 
	private static final String KEY_LIST = "professores"; 
	private static final String KEY_ATTR = "professor"; 
	private static final String KEY_MSG = "mensagem"; 
	
	@Autowired
	private ProfessorService service;
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new DateConverter(new SimpleDateFormat("yyyy-MM-dd")));
    }
	
	@Override
	@RequestMapping(value = "/novo")
	public String novo(Map<String, Object> map) {
		map.put(KEY_ATTR, new Professor());
		map.put("sexos", TipoSexo.values());
		return URL_FORM;
	}
	
	@Override
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String delete(Long id, Model model) {
		service.delete(id);
		model.addAttribute(KEY_MSG, new Mensagem("Sucesso ao excluir", TipoMensagem.SUCESSO));
		return "forward:/"+URL_LIST;
	}
	
	@Override
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getForId(Long id, Model model) {
		Professor professor = service.get(id);
		model.addAttribute(KEY_ATTR, professor);
		model.addAttribute("sexos", TipoSexo.values());
		return URL_FORM;
	}
	
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listar(Map<String, Object> map) {
		map.put(KEY_LIST, service.listar());
		map.put(KEY_ATTR, new Professor());
		return URL_LIST;
	}
	
	@Override
	@PostMapping(value = "/salvar")
	public String salvar(@Valid @ModelAttribute(KEY_ATTR) Professor professor, BindingResult result, RedirectAttributes attr ) {
		if(result.hasErrors()) {
			return URL_FORM;
		}else {
			service.save(professor);
			attr.addFlashAttribute(KEY_MSG, new Mensagem("Salvo com sucesso!", TipoMensagem.SUCESSO));
			return "redirect:/"+URL_LIST;
		}
	}
	@PostMapping(value = "/atualizar")
	public String atualizar(@Valid @ModelAttribute(KEY_ATTR) Professor professor, BindingResult result, RedirectAttributes attr ) {
		if(result.hasErrors()) {
			return URL_FORM;
		}else {
			service.update(professor);
			attr.addFlashAttribute(KEY_MSG, new Mensagem("Atualizado com sucesso!", TipoMensagem.SUCESSO));
			return URL_FORM;
		}
	}
	
	@Override
	@RequestMapping(value="/cancelar")
	public String cancelar(Map<String, Object> map) {
		return "redirect:/"+URL_LIST;
	}
	
	@Override
	@RequestMapping(value="/pesquisar", method = RequestMethod.GET)
	public String pesquisar( Professor professor, Model model) {
		model.addAttribute(KEY_LIST, service.buscar(professor));
		return URL_LIST;
	}
}
