package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacaoEnum;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		

		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacaoEnum.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(categoria);
		movimentacao.setCategoria(categorias);
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem à Paraiba");
		movimentacao2.setTipoMovimentacao(TipoMovimentacaoEnum.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(500.0));
		List<Categoria> categorias2 = new ArrayList<Categoria>();
		categorias2.add(categoria2);
		movimentacao2.setCategoria(categorias2);
		movimentacao2.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
