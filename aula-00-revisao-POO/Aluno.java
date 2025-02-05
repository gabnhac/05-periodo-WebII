public class Aluno extends Pessoa{
    private long matricula;

    public Aluno(){
        this("",0,0,0);

    }

    public Aluno(String nome, int idade){
        this("",idade,0,0);
    }

    public Aluno(String nome, int idade, long cpf, long matricula){
        super(nome, idade, cpf);
        this.matricula = matricula;
    }

    public long getMatricula() {
        return matricula;
    }
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
}