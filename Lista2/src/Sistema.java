import java.io.*;
import java.util.Scanner;

public class Sistema {

    public static void insereAluno() {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("alunos.txt", true));


            String linha = recebeDadosAluno();

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

    static String recebeDadosAluno() {
        System.out.print("Informe o codigo de pessoa: ");
        int codigo = Teclado.readInt();

        System.out.print("Nome: ");
        String nomePessoa = Teclado.readLine();

        System.out.print("Idade: ");
        int idadePessoa = Teclado.readInt();

        String linha = linha = codigo + " " + nomePessoa + " " + idadePessoa;

        return linha;
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
                sb.append("Codigo: " + codigo + "   |   Nome: " + nome + "   |   Idade: " + idade + "\n");
            }
        }
        if (sb.length() == 0) {
            sb.append("Aluno não encontrado.");
        }
        return sb;
    }

    private static void backupArquivo() throws IOException {
        BufferedWriter backup = null;
        try {
            backup = new BufferedWriter(new FileWriter("alunos(backup).txt"));
            Scanner in = new Scanner(new FileReader("alunos.txt"));

            while (in.hasNextLine()) {
                String linha = in.nextLine();
                backup.write(linha);
                backup.newLine();
                backup.flush();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // fechamento do arquivo alunos.txt
            if (backup != null) {
                try {
                    System.out.println("Backup efetuado com sucesso");
                    backup.close();
                } catch (IOException ioe2) {
                    // just ignore it
                }
            }
        }
    }

    private static void estatistica() throws IOException {
        BufferedWriter estatistica = null;
        try {
            estatistica = new BufferedWriter(new FileWriter("estatistica.txt"));
            Scanner in = new Scanner(new FileReader("alunos.txt"));

            int maiorIdade = 0, idadeAtual ,mediaIdade = 0, somaIdade = 0, quantidadeAlunos = 0;

            while (in.hasNextLine()) {
                quantidadeAlunos++;

                String line = in.nextLine();
                String[] linha = line.split(" ");
                idadeAtual = Integer.parseInt(linha[2]);
                if (idadeAtual > maiorIdade){
                    maiorIdade = idadeAtual;
                }
                somaIdade+= Integer.parseInt(linha[2]);
            }
            mediaIdade = (somaIdade/quantidadeAlunos);
            estatistica.write("Numero de Alunos: " + quantidadeAlunos);
            estatistica.newLine();
            estatistica.write("Media de Idade: " + mediaIdade);
            estatistica.newLine();
            estatistica.write("Maior Idade: " + maiorIdade);
            estatistica.newLine();
            estatistica.flush();


        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // fechamento do arquivo alunos.txt
            if (estatistica != null) {
                try {
                    estatistica.close();
                } catch (IOException ioe2) {
                    // just ignore it
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        insereAluno();
        System.out.println(getInfoAluno());
        backupArquivo();
        estatistica();
    }
}
