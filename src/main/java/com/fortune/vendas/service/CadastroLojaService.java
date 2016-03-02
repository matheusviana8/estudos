package com.fortune.vendas.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortune.vendas.model.Loja;
import com.fortune.vendas.repository.LojaRepository;

@Transactional
@Service
public class CadastroLojaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LojaRepository lojas;

	@Transactional
	public void salvar(Loja loja) {
		lojas.guardar(loja);
	}

	public List<Loja> listar() {
		return lojas.listar();
	}

}
