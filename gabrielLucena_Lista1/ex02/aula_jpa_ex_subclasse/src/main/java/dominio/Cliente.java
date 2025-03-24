package dominio;

import javax.persistence.Entity;

@Entity //entidade de domínio
public class Cliente extends Pessoa {
	
	//private static final long serialVersionUID = 1L; //Id padrão do Serializable
	
	private int codCliente;
	
	public Cliente() {
		this("",0,0);
	}
	
	public Cliente(String nome, int idade, int codCliente) {
		super(nome,idade);
		setCodCliente(codCliente);
	}
	
	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	@Override
	public String toString() {
		return "Aluno [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + ", codCliente= "
		+ getCodCliente() + "]";
	}
	/*
	public void imprimeDados() {
		System.out.println("Nome: "+ super.getNome());
		System.out.println("CPF: "+ super.getCpf());
		System.out.println("Matricula Aluno: "+ getMatriculaAluno());
	}
	*/
}