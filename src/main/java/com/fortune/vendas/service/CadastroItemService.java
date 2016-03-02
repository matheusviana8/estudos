package com.fortune.vendas.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortune.vendas.model.Item;
import com.fortune.vendas.repository.ItemRepository;

@Service
@Transactional
public class CadastroItemService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ItemRepository itens;
	
	@Transactional
	public void salvar(Item item) {
		itens.guardar(item);
	}
	
	@Transactional
	public List<Item> listar() {
		return itens.listar();
	}

}
