package com.example.merc97.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.merc97.model.Mercadoria;
import com.example.merc97.model.TipoNegocio;

public class MercadoriaDao {
	private Connection connection;

	public MercadoriaDao() {
		connection = new ConnectionFactory().getConnection();

	}

	/*
	 * private int id; private String tipo; private String nome; private int
	 * quantidade; private double preço; private TipoNegocio tipoNegocio;
	 */
	public void inserir(Mercadoria m) {
		String sql = "INSERT INTO mercadoria(id, tipo, nome, quantidade, preco, tipoNegocio) values(?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, m.getId());
			stmt.setString(2, m.getTipo());
			stmt.setString(3, m.getNome());
			stmt.setInt(4, m.getQuantidade());
			stmt.setDouble(5, m.getPreço());
			stmt.setInt(6, m.getTipoNegocio().ordinal());

			stmt.execute();
			stmt.close();
			connection.close();

			System.out.println("Salvo");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void close() {

		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public List<Mercadoria> getMercadorias() {
		List<Mercadoria> lista = new ArrayList<Mercadoria>();

		String sql = "select * from mercadoria";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Mercadoria m = new Mercadoria();
				m.setId(rs.getInt("id"));
				m.setTipo(rs.getString("tipo"));
				m.setNome(rs.getString("nome"));
				m.setQuantidade(rs.getInt("quantidade"));
				m.setPreço(rs.getDouble("preco"));
				m.setTipoNegocio(TipoNegocio.values()[rs.getInt("tipoNegocio")]);
				lista.add(m);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return lista;

	}

}
