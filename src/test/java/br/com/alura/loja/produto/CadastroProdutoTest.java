package br.com.alura.loja.produto;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroProdutoTest {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi Note 11s");
		celular.setDescricao("Ótimo");
		celular.setPreco(new BigDecimal(1900));

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);

		em.getTransaction().begin();
		dao.save(celular);
		em.getTransaction().commit();
		em.close();
	}

}
