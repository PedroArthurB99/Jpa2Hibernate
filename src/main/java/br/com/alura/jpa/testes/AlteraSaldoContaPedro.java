package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaPedro {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoPedro = em.find(Conta.class, 1);
		
		em.getTransaction().begin();
		contaDoPedro.setSaldo(20.0);
		em.getTransaction().commit();
	}

}
