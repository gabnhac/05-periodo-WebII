package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			//Instancia o EntityManagerFactory com as configurações de persistencia
			emf = Persistence.createEntityManagerFactory("aula-jpa"); 
			//Intancia o EntityManager
			em = emf.createEntityManager(); 
			
			em.getTransaction().begin();
	
			// Inserir os objetos aqui!
			Produto p1 = new Produto("Barra de chocolate", 5);
			Produto p2 = new Produto("Lâmpada", 20);
			Produto p3 = new Produto("Churrasqueira", 45);
			Produto p4 = new Produto("Bola", 30);

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);

			Cliente c1 = new Cliente("Gabriel Lucena");
			Cliente c2 = new Cliente("Alessandra");
			Cliente c3 = new Cliente("Pedro");
			Cliente c4 = new Cliente("Cebastião");

			Venda v1 = new Venda(25);
			v1.setProdutos(Arrays.asList(p1, p2));
			v1.setCliente(c1);

			Venda v2 = new Venda(75);
			v2.setProdutos(Arrays.asList(p3, p4));
			v2.setCliente(c2);

			Venda v3 = new Venda(65);
			v3.setProdutos(Arrays.asList(p3, p2));
			v3.setCliente(c3);

			Venda v4 = new Venda(35);
			v4.setProdutos(Arrays.asList(p1, p4));
			v4.setCliente(c4);

			p1.setVenda(Arrays.asList(v1,v4));
			p2.setVenda(Arrays.asList(v1,v3));
			p3.setVenda(Arrays.asList(v2,v3));
			p4.setVenda(Arrays.asList(v2,v4));

			c1.setVendas(Arrays.asList(v1));
			c2.setVendas(Arrays.asList(v2));
			c3.setVendas(Arrays.asList(v3));
			c4.setVendas(Arrays.asList(v4));

			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(c4);

			em.persist(v1);
			em.persist(v2);
			em.persist(v3);
			em.persist(v4);
			
			em.getTransaction().commit();//confirmar as alterações realizadas
			
			emf.close();
			em.close();
			
			// Inserir os laços for aqui!
			
		}catch (Exception e){
			if(em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
			}
			if(emf != null) {
				emf.close();
			}
		}
	}			
}
