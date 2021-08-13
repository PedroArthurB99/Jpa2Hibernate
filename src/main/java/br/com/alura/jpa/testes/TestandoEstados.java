package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	
	public static void main (String[] args) {
		
		//Objeto Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(165654);
		conta.setNumero(546564);
		conta.setSaldo(400.0);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Transforma um objeto Transient em Managed
		em.persist(conta);
		
		//Transforma um objeto Managed em Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}

}
