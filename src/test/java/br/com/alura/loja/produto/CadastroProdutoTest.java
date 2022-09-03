package br.com.alura.loja.produto;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroProdutoTest {

	public static void main(String[] args) {
		Produto celular = 
				new Produto("Xiaomi Redmi Note 11s","Ótimo",new BigDecimal(1900),Categoria.CELULARES);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);

		em.getTransaction().begin();
		dao.save(celular);
		em.getTransaction().commit();
		em.close();
	}

}
