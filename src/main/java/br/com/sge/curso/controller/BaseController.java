package br.com.sge.curso.controller;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sge.curso.domain.BaseModel;

public abstract class BaseController<T extends BaseModel, I extends Number> {
	
	public abstract String delete(I id, Model model);
	public abstract String getForId(I id, Model model);
	public abstract String salvar(T usuario, BindingResult result, RedirectAttributes attr );
	public abstract String listar(Map<String, Object> map);
	public abstract String novo(Map<String, Object> map);
	public abstract String cancelar(Map<String, Object> map);
	public abstract String pesquisar( T obj, Model model);

}
