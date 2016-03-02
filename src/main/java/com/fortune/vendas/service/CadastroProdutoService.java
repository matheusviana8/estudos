package com.fortune.vendas.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortune.vendas.model.Produto;
import com.fortune.vendas.repository.ProdutoRepository;

@Service
@Transactional
public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoRepository produtos;
	
	@Transactional
	public void salvar(Produto produto) {
		produtos.guardar(produto);
	}
	@Transactional
	public List<Produto> listar() {
		return produtos.listar();
	}

}
