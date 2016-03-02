package com.fortune.vendas.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.fortune.vendas.model.Item;


@Repository
public class ItemRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager manager;
	
	public Item guardar(Item item) {
		return manager.merge(item);
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> listar(){
		return manager.createQuery("from Item").getResultList();
	}
}
