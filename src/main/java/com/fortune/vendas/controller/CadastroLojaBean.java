package com.fortune.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.fortune.vendas.model.Loja;
import com.fortune.vendas.service.CadastroLojaService;

@Named
@ViewScoped
public class CadastroLojaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CadastroLojaService lojaService;

	private Loja loja = new Loja();
	private List<Loja> lojas;

	public void novoItem() {
		loja = new Loja();
	}

	public void inicializar() {
		lojas = listar();
	}

	public void salvar() {
		lojaService.salvar(loja);

		FacesMessage msg = new FacesMessage("Loja cadastrada com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Loja> listar() {
		return lojaService.listar();
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public boolean isEditando() {
		return this.loja.getId() != null;
	}
	
	

}