import java.io.IOException;

public class Sistema {

    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo("Alunos");

        Aluno aluno1 = new Aluno("Luis", 23);
        Aluno aluno2 = new Aluno("Mariana", 15);
        Aluno aluno3 = new Aluno("Pedro", 33);
        Aluno aluno4 = new Aluno("Valeria",  26);
        Aluno aluno5 = new Aluno("Richard",  14);
        Aluno aluno6 = new Aluno("Mateus",  19);
        Aluno aluno7 = new Aluno("Larissa",  36);
        Aluno aluno8 = new Aluno("Frederico",  18);
        Aluno aluno9 = new Aluno("Tiago",  22);

        arquivo.salvarRegistro(aluno1);
        arquivo.salvarRegistro(aluno2);
        arquivo.salvarRegistro(aluno3);
        arquivo.salvarRegistro(aluno4);
        arquivo.salvarRegistro(aluno5);
        arquivo.salvarRegistro(aluno6);
        arquivo.salvarRegistro(aluno7);
        arquivo.salvarRegistro(aluno8);
        arquivo.salvarRegistro(aluno9);

        System.out.println(arquivo.pesquisaArquivo("Mariana"));

        System.out.println(arquivo.pesquisaBinaria(7));
    }

}
