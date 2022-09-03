package br.com.alura.loja.produto;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroProdutoTest {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi Note 11s");
		celular.setDescricao("Ótimo");
		celular.setPreco(new BigDecimal(1900));
		
		// responsavel pela criação do entityManager
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("default"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}

}
