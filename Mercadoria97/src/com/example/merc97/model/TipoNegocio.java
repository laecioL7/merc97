package com.example.merc97.model;

public enum TipoNegocio {
	COMPRA("Compra"), VENDA("Venda");
	// var para descrever
	private String descricao;

	// construtor privado
	private TipoNegocio(String des) {
		// populando a descrição
		this.descricao = des;
	}
	
	@Override
	public String toString() {
	
		return this.descricao;
	}
}
