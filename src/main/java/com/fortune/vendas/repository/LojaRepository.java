package com.fortune.vendas.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fortune.vendas.model.Loja;

@Repository
public class LojaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;
	
	public Loja guardar(Loja loja) {
		return manager.merge(loja);
	}
	
	@SuppressWarnings("unchecked")
	public List<Loja> listar(){
		return manager.createQuery("from Loja").getResultList();
	}
}
