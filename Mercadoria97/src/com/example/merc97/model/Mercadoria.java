package com.example.merc97.model;
/**
 * Código da Mercadoria, Tipo da Mercadoria,
 * Nome da Mercadoria, Quantidade, Preço, Tipo do Negócio(Compra ou Venda)*/
public class Mercadoria {
	private int id;
	private String tipo;
	private String nome;
	private int quantidade;
	private double preço;
	private TipoNegocio tipoNegocio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	

}
