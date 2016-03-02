package com.fortune.vendas.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loja database table.
 * 
 */
@Entity
@NamedQuery(name="Loja.findAll", query="SELECT l FROM Loja l")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String bairro;

	private String cidade;

	private String endereco;

	private String nome;

	private String telefone;

	private String uf;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="loja", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;

	public Loja() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setLoja(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setLoja(null);

		return item;
	}

}