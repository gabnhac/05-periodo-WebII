package aplicativo;

import dominio.Vendedor;
import dominio.Cliente;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); //Instancia o EntityManagerFactory com as configurações de persistencia
		EntityManager em = emf.createEntityManager(); //Intancia o EntityManager
		
		Vendedor v1 = new Vendedor("Gabriel", 21, 01);
		Cliente c1 = new Cliente("Rafael", 34, 01);
		
		em.getTransaction().begin();// iniciar transação com banco de dados
		
		em.persist(v1);
		em.persist(c1);

		
		em.getTransaction().commit();//confirmar as alterações realizadas
		
		emf.close();
		em.close();
	}			
}