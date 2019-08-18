import java.io.*;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException { // menu principal
        int opcao = 0;
        do {
            System.out.println("\n### SCA - Sistema de Cadastro de Alunos ###");
            System.out.println("       =============================         ");
            System.out.println("      |    1. Inserir novo aluno    |");
            System.out.println("      |    2. Pesquisar aluno       |");
            System.out.println("      |    3. Listar alunos         |");
            System.out.println("      |    4. Fazer backup          |");
            System.out.println("      |    5. Estatísticas          |");
            System.out.println("      |                             |");
            System.out.println("      |    0. Sair                  |");
            System.out.println("       =============================\n");

            System.out.print("Informe uma opcao: ");
            opcao = Teclado.readInt();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    insereAluno();
                    break;
                case 2:
                    System.out.println(getInfoAluno());
                    break;
                case 3:
                    listaAlunos();
                    break;
                case 4:
                    backupArquivo();
                    break;
                case 5:
                    System.out.println(estatistica());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

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

    private static void listaAlunos() throws IOException {
        Scanner alunos = new Scanner(new FileReader("alunos.txt"));
        //StringBuilder alunosString = new StringBuilder();
        int contador = 1;

        while (alunos.hasNextLine()) {
            String linha = alunos.nextLine();
            String[] dadosAlunos = linha.split(" ");
            System.out.println(contador + ". " + dadosAlunos[1] + "");
            contador++;
            //alunosString.append(contador + ". " + dadosAlunos[0] + "\n");
        }
    }

    private static void backupArquivo() throws IOException {
        BufferedWriter backup = null;
        try {
            backup = new BufferedWriter(new FileWriter("alunos(backup).txt"));
            Scanner alunos = new Scanner(new FileReader("alunos.txt"));

            while (alunos.hasNextLine()) {
                String linha = alunos.nextLine();
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

    private static StringBuilder estatistica() throws IOException {
        BufferedWriter estatistica = null;
        StringBuilder estatisticaString = new StringBuilder();
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

            estatisticaString.append("Numero de Alunos: " + quantidadeAlunos).append("\nMedia de Idade: " + mediaIdade).append("\nMaior Idade: " + maiorIdade);

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

        return estatisticaString;
    }

}
