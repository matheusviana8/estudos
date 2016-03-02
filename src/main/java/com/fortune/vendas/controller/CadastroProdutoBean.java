package com.fortune.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.fortune.vendas.model.Produto;
import com.fortune.vendas.service.CadastroProdutoService;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CadastroProdutoService produtoService;
	
	private Produto produto = new Produto();
	private List<Produto> produtos;

	
	public void novoItem() {
		produto = new Produto();
	}
	
	public void inicializar(){
		produtos = listar();
	}

	public void salvar() {
		produtoService.salvar(produto);

		FacesMessage msg = new FacesMessage("Produto cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Produto> listar() {
		return produtoService.listar();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean isEditando() {
		return this.produto.getId() != null;
	}

}