import java.io.IOException;

public class Sistema {

    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo("Alunos.txt");

        Aluno aluno1 = new Aluno("Luis", 123, 23);
        Aluno aluno2 = new Aluno("Mariana", 188, 15);
        Aluno aluno3 = new Aluno("Pedro", 156, 33);
        Aluno aluno4 = new Aluno("Valeria", 199, 26);

        arquivo.salvarRegistro(aluno1);
        arquivo.salvarRegistro(aluno2);
        arquivo.salvarRegistro(aluno3);
        arquivo.salvarRegistro(aluno4);

        System.out.println(arquivo.pesquisaArquivo("Pedro"));

        System.out.println(arquivo.pesquisaTernario(199));

    }

}
