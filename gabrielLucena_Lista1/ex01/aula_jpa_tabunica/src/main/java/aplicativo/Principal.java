package aplicativo;

import dominio.Pessoa;
import dominio.Cliente;
import dominio.Vendedor;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); //Instancia o EntityManagerFactory com as configurações de persistencia
		EntityManager em = emf.createEntityManager(); //Intancia o EntityManager
		
		Pessoa jose = new Pessoa("José", 35);
		Vendedor gabriel = new Vendedor("Gabriel", 21, 01);
		Cliente rafael = new Cliente("Rafael", 34, 01);
		
		em.getTransaction().begin();// iniciar transação com banco de dados
		
		em.persist(jose);
		em.persist(gabriel);
		em.persist(rafael);
		
		em.getTransaction().commit();//confirmar as alterações realizadas
		
		emf.close();
		em.close();
		
	}			
}