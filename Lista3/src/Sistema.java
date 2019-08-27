import java.io.IOException;

import static java.awt.SystemColor.menu;

public class Sistema {

    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo("Alunos");

//        Aluno aluno1 = new Aluno("Antonio", 23);
//        Aluno aluno2 = new Aluno("Mariana", 15);
//        Aluno aluno3 = new Aluno("Gilberto", 33);
//        Aluno aluno4 = new Aluno("Valeria", 26);
//        Aluno aluno5 = new Aluno("Richard", 14);
//        Aluno aluno6 = new Aluno("Mateus", 19);
//        Aluno aluno7 = new Aluno("Larissa", 36);
//        Aluno aluno8 = new Aluno("Frederico", 18);
//        Aluno aluno9 = new Aluno("Anderson", 22);
//        Aluno aluno10 = new Aluno("Marcello", 28);
//
//        arquivo.salvarRegistro(aluno1);
//        arquivo.salvarRegistro(aluno2);
//        arquivo.salvarRegistro(aluno3);
//        arquivo.salvarRegistro(aluno4);
//        arquivo.salvarRegistro(aluno5);
//        arquivo.salvarRegistro(aluno6);
//        arquivo.salvarRegistro(aluno7);
//        arquivo.salvarRegistro(aluno8);
//        arquivo.salvarRegistro(aluno9);
//        arquivo.salvarRegistro(aluno10);
//
//        System.out.println(arquivo.pesquisaArquivo("Mariana"));
//
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(arquivo.pesquisaTernaria(i));
//        }

        menu(arquivo);
    }

    private static void menu(Arquivo arquivo) throws IOException { // menu principal
        int opcao = 0;
        do {
            System.out.println("\n ### SCA - Sistema de Cadastro de Alunos ###");
            System.out.println("       ==================================");
            System.out.println("      |    1. Inserir novo aluno         |");
            System.out.println("      |    2. Listar alunos              |");
            System.out.println("      |    3. Pesquisa por nome          |");
            System.out.println("      |    4. Pesquisar aluno Binario    |");
            System.out.println("      |    5. Pesquisar aluno Ternario   |");
            System.out.println("      |                                  |");
            System.out.println("      |    0. Sair                       |");
            System.out.println("       ==================================\n");

            System.out.print("Informe uma opcao: ");
            opcao = Teclado.readInt();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    Aluno aluno;

                    System.out.print("Informe o nome do aluno: ");
                    String nomePessoa = Teclado.readLine();

                    System.out.print("Idade: ");
                    int idadePessoa = Teclado.readInt();

                    aluno = new Aluno(nomePessoa, idadePessoa);
                    arquivo.salvarRegistro(aluno);
                    break;
                case 2:
                    arquivo.listarArquivo();
                    break;
                case 3:
                    System.out.print("Informe o nome do aluno: ");
                    String nome = Teclado.readLine();
                    System.out.println(arquivo.pesquisaArquivo(nome));
                    break;
                case 4:
                    System.out.print("Informe o codigo do aluno: ");
                    int codigoBi = Teclado.readInt();
                    System.out.println(arquivo.pesquisaBinaria(codigoBi));
                    break;
                case 5:
                    System.out.print("Informe o codigo do aluno: ");
                    int codigoTer = Teclado.readInt();
                    System.out.println(arquivo.pesquisaTernaria(codigoTer));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }


}


