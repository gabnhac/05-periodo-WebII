package aplicativo;
import dominio.Pessoa;
import dominio.Professor;
import dominio.Aluno;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class Principal {
public static void main(String[] args) {
//Instancia o EntityManagerFactory com as configurações de persistencia
EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
//Intancia o EntityManager
EntityManager em = emf.createEntityManager();
Professor professor1 = new Professor("Rafael", "XXX.XXX.XXX-XX", 0001);
Aluno aluno1 = new Aluno("Miguel", "XXX.XXX.XXX-XX", 0001);
Professor professor2 = new Professor("Gabriel", "XXX.XXX.XXX-XX", 0001);
Aluno aluno2 = new Aluno("Uriel", "XXX.XXX.XXX-XX", 0001);
em.getTransaction().begin();// iniciar transação com banco de dados
em.persist(professor1);
em.persist(aluno1);
em.persist(professor2);
em.persist(aluno2);
//consulta em jpql
Query consultaP = em.createQuery("select professor from Professor professor");
ArrayList<Professor> listaP = (ArrayList<Professor>) consultaP.getResultList();
//consulta em jpql
Query consultaA = em.createQuery("select aluno from Aluno aluno");
ArrayList<Aluno> listaA = (ArrayList<Aluno>) consultaA.getResultList();
em.getTransaction().commit();//confirmar as alterações realizadas
emf.close();
em.close();
for(Professor objP: listaP) {
System.out.println(objP);
}
for(Aluno objA: listaA) {
System.out.println(objA);
}
}
}
