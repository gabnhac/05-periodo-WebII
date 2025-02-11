public class Professor extends Pessoa {
    private int idProfessor;

    public Professor(){
        this("",0,0l,0);

    }
    
    public Professor(String nome, int idade){
        this(nome, idade, 0l, 0);
    }
    public Professor(String nome, int idade, long cpf, int idProfessor){
        super(nome, idade, cpf);
        this.idProfessor = idProfessor;
        
    }

    public int getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Override
    public String toString(){
        return "Professor{" + super.toString() + ", idProfessor=" + getIdProfessor() + "}";
    }


}