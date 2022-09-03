package br.com.alura.loja.produto;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroProdutoTest {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi Note 11s", "Ótimo", new BigDecimal(1900), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);

		em.getTransaction().begin();
		produtoDao.save(celular);
		categoriaDao.save(celulares);
		em.getTransaction().commit();
		em.close();
	}

}
