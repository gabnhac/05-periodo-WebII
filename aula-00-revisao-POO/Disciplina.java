import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public Disciplina(){
        this("", new ArrayList<Aluno>(), new ArrayList<Professor>());
    }

    public Disciplina(String nomeDisciplina){
        this(nomeDisciplina, new ArrayList<Aluno>(), new ArrayList<Professor>());
    }

    public Disciplina(String nomeDisciplina, List<Professor> professores, List<Aluno> alunos){
        this.nomeDisciplina = nomeDisciplina;
        this.alunos = alunos;
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
    public List<Professor> getProfessores() {
        return professores;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void addProfessor(Professor professor){
        this.professores.add(professor);
    }
    public void addAluno(Aluno aluno){
        this.aluno.add(aluno);
    }
}