package com.fortune.vendas.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.fortune.vendas.model.Produto;

@Repository
public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;
	
	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	public Produto porId(Long id) {

		return manager.find(Produto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){
		return manager.createQuery("from Produto").getResultList();
	}
}
