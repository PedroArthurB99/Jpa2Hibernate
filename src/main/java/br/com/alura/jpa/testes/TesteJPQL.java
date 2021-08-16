package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String queryJPQL = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta ORDER BY m.valor DESC";
		
		Conta conta = new Conta();
		conta.setId(3);
		
		TypedQuery<Movimentacao> query = em.createQuery(queryJPQL, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> resultList = query.getResultList();
		
		for(Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}

		em.close();

	}

}
