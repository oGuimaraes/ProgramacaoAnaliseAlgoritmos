import java.io.*;
import java.util.Scanner;

public class Sistema {

    public static void insereAluno() {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("alunos.txt", true));

            System.out.print("Informe o codigo de pessoa: ");
            int codigo = Teclado.readInt();

            System.out.print("Nome: ");
            String nomePessoa = Teclado.readLine();

            System.out.print("Idade: ");
            int idadePessoa = Teclado.readInt();

            String linha = codigo + " " + nomePessoa + " " + idadePessoa;

            bw.write(linha);
            bw.newLine();
            bw.flush();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // fechamento do arquivo alunos.txt
            if (bw != null) {
                try {
                    System.out.println("Dados Gravados com sucesso");
                    bw.close();
                } catch (IOException ioe2) {
                    // just ignore it
                }
            }
        }
    }

    public static void pesquisaAluno(){

    }

    private static StringBuilder getInfoAluno() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("alunos.txt"));

        String nome = null, idade = null, codigo = null;

        System.out.print("Digite o nome ou idade: ");
        String chave = Teclado.readLine();

        StringBuilder sb = new StringBuilder();
        System.out.println();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] linha = line.split(" ");

            if (linha[1].equals(chave) || linha[2].equals(chave) ) {
                codigo = linha[0];
                nome = linha[1];
                idade = linha[2];
                sb.append("Codigo: " + codigo + "| Nome: " + nome + " | Idade: " + idade + "\n");
            }
        }
        if (sb.length() == 0) {
            sb.append("Aluno não encontrado.");
        }
        return sb;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getInfoAluno());
    }
}
