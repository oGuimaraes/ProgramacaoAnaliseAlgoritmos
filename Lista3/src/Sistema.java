import java.io.IOException;

public class Sistema {

    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo("Alunos");

        Aluno aluno1 = new Aluno("Luis", 23);
        Aluno aluno2 = new Aluno("Mariana", 15);
        Aluno aluno3 = new Aluno("Pedro", 33);
        Aluno aluno4 = new Aluno("Valeria",  26);

        arquivo.salvarRegistro(aluno1);
        arquivo.salvarRegistro(aluno2);
        arquivo.salvarRegistro(aluno3);
        arquivo.salvarRegistro(aluno4);

        System.out.println(arquivo.pesquisaArquivo("Mariana"));

        System.out.println(arquivo.pesquisaTernario(4));

    }

}
