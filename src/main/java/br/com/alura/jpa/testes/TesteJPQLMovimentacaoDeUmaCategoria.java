package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String queryJPQL = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria";
		
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		
		TypedQuery<Movimentacao> query = em.createQuery(queryJPQL, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = query.getResultList();
		
		for(Movimentacao movimentacao : resultList) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}

		em.close();
	}
}
