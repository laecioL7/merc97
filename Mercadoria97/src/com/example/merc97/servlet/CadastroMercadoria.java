package com.example.merc97.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.merc97.dao.MercadoriaDao;
import com.example.merc97.model.Mercadoria;
import com.example.merc97.model.TipoNegocio;

/**
 * Teremos uma plataforma de negociação de mercadorias. Que obrigatoriamente
 * deverá ter os seguintes campos: Código da Mercadoria, Tipo da Mercadoria,
 * Nome da Mercadoria, Quantidade, Preço, Tipo do Negócio(Compra ou Venda). Ao
 * confirmar, essa operação irá para uma lista de operações, que poderão ser
 * visualizadas posteriormente.
 */
@WebServlet("/AddMercadoria")
public class CadastroMercadoria extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("*service");
		/* recebendo os dados */
		//String id = req.getParameter("id");
		String tipo = req.getParameter("tipo");
		String nome = req.getParameter("nome");
		String quantidade = req.getParameter("quantidade");
		String preço = req.getParameter("preço");
		String tipoNegocio = req.getParameter("tipoNegocio");
		
		Mercadoria m = new Mercadoria();
		//m.setId(Integer.parseInt(id));
		m.setNome(nome);
		m.setTipo(tipo);
		m.setQuantidade(Integer.parseInt(quantidade));
		/* , for . */
		preço = preço.replace(",", ".");
		m.setPreço((double)Double.parseDouble(preço));
		m.setTipoNegocio(TipoNegocio.valueOf(tipoNegocio));
		
		/*salvar*/
		MercadoriaDao dao = new MercadoriaDao();
		dao.inserir(m);
		
		RequestDispatcher r = req.getRequestDispatcher("cadastroMercadoria.jsp");
		r.forward(req, resp);
		
	}

}
