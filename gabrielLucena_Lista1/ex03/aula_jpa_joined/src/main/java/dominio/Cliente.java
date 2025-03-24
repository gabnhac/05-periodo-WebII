package dominio;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
		
	private int codCliente;
	
	public Cliente() {
		this("",0,0);
	}
	
	public Cliente(String nome, int idade, int codCliente) {
		super(nome,idade);
		setCodCliente(codCliente);
	}
	
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodCliente() {
		return codCliente;
	}
	
	@Override
	public String toString() {
		return "Aluno [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + ", codCliente= "
		+ getCodCliente() + "]";
	}
	
	public void imprimeDados() {
		System.out.println("Nome: "+ super.getNome());
		System.out.println("CPF: "+ super.getIdade());
		System.out.println("codCliente: "+ getCodCliente());
	}
}