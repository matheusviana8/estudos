package com.fortune.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fortune.vendas.model.Item;
import com.fortune.vendas.model.Produto;
import com.fortune.vendas.service.CadastroItemService;
import com.fortune.vendas.service.CadastroProdutoService;

@Named
@ViewScoped
public class CadastroItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CadastroItemService itemService;
	@Autowired
	private CadastroProdutoService produtoService;

	private Item item = new Item();
	private List<Item> itens;
	private List<Produto> produtos;
	
	public void novoItem() {
		item = new Item();
	}
	
	public void inicializar(){
		itens = listar();
	}
	@Transactional
	public void salvar() {
		itemService.salvar(item);

		FacesMessage msg = new FacesMessage("Loja cadastrada com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Item> listar() {
		return itemService.listar();
	}
	
	public List<Produto> complete(String nome) {
		List<Produto> queryResult = new ArrayList<Produto>();

		if (produtos== null) {
			
			produtos = produtoService.listar();
		}
                
		for (Produto produto : produtos) {
			if (produto.getDescricao().toLowerCase().contains(nome.toLowerCase())) {
				queryResult.add(produto);
			}
		}

		return queryResult;
	}
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public boolean isEditando() {
		return this.item.getId() != null;
	}

}