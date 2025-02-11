public class Principal{
    public static void main(String[] args){
        Pessoa pessoaPadrao = new Pessoa("Gabriel", 21, 12312334567L);
        System.out.println(pessoaPadrao.toString());

        Aluno a = new Aluno("Gabriel", 21, 53647364981L, 3918274);
        System.out.println(a.toString());
    }
    
}