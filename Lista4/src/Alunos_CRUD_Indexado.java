import java.util.Scanner;

public class Alunos_CRUD_Indexado {

    private static Scanner console = new Scanner(System.in);
    private static ArquivoIndexado<Aluno> arqAlunos;

    public static void main(String[] args) {

        try {

            arqAlunos = new ArquivoIndexado<>(Aluno.class.getConstructor(), "alunos.db", "alunos.idx");

            // menu
            int opcao;
            do {
                System.out.println("\n\nGESTÃO DE Alunos");
                System.out.println("-----------------------------\n");
                System.out.println("1 - Listar");
                System.out.println("2 - Incluir");
                System.out.println("3 - Alterar");
                System.out.println("4 - Excluir");
                System.out.println("5 - Buscar");
                System.out.println("0 - Sair");
                System.out.print("\nOpcao: ");
                opcao = Integer.valueOf(console.nextLine());

                switch(opcao) {
                    case 1: listarAlunos(); break;
                    case 2: incluirAluno(); break;
                    case 3: alterarAluno(); break;
                    case 4: excluirAluno(); break;
                    case 5: buscarAluno(); break;

                    case 0: break;
                    default: System.out.println("Opção inválida");
                }

            } while(opcao!=0);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void listarAlunos() throws Exception {

        Object[] obj = arqAlunos.listar();

        System.out.println("\nLISTA DE ALUNOS");
        for(int i=0; i<obj.length; i++) {
            System.out.println((Aluno)obj[i]);
        }
        pausa();

    }

    public static void incluirAluno() throws Exception {

        String nome;
        String curso;
        int idade;

        System.out.println("\nINCLUSÃO DE ALUNO");
        System.out.print("Nome: ");
        nome = console.nextLine();
        System.out.print("Curso: ");
        curso = console.nextLine();
        System.out.print("Idade: ");
        idade = Integer.parseInt(console.nextLine());

        System.out.print("\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
            Aluno obj = new Aluno(-1, nome, idade, curso);
            int id = arqAlunos.incluir(obj);
            System.out.println("Aluno incluido com ID: "+id);
        }

        pausa();
    }


    public static void alterarAluno() throws Exception {

        System.out.println("\nALTERAÇÃO DE ALUNO");

        int id;
        System.out.print("ID do livro: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0)
            return;

        Aluno obj;
        if( (obj = (Aluno)arqAlunos.buscar(id))!=null ) {
            System.out.println(obj);

            String nome;
            String curso;
            int idade;

            System.out.println("\nALTERACAO DE ALUNO");
            System.out.print("Nome: ");
            nome = console.nextLine();
            System.out.print("Idade: ");
            idade = console.nextInt();
            System.out.print("Curso: ");
            curso = console.nextLine();

            if(nome.length()>0 || curso.length()>0 || idade>=0) {
                System.out.print("\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='s' || confirma=='S') {

                    obj.nome = (nome.length()>0 ? nome : obj.nome);
                    obj.curso = (curso.length()>0 ? curso : obj.curso);
                    obj.idade = (idade>=0?idade:obj.idade);

                    if(arqAlunos.alterar(obj) )
                        System.out.println("Alunos Alterado.");
                    else
                        System.out.println("Aluno não pode ser alterado.");
                }
            }
        }
        else
            System.out.println("Aluno não encontrado");
        pausa();

    }


    public static void excluirAluno() throws Exception {

        System.out.println("\nEXCLUSÃO DE ALUNO");

        int id;
        System.out.print("ID do aluno: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0)
            return;

        Aluno obj;
        if( (obj = (Aluno)arqAlunos.buscar(id))!=null ) {
            System.out.println(obj);

            System.out.print("\nConfirma exclusão? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                if( arqAlunos.excluir(id) ) {
                    System.out.println("Aluno excluído.");
                }
            }
        }
        else
            System.out.println("Aluno não encontrado");
        pausa();

    }


    public static void buscarAluno() throws Exception {

        System.out.println("\nBUSCA DE ALUNO POR CÓDIGO");

        int codigo;
        System.out.print("Código: ");
        codigo = Integer.valueOf(console.nextLine());
        if(codigo <=0)
            return;

        Aluno obj;
        if( (obj = (Aluno)arqAlunos.buscar(codigo))!=null )
            System.out.println(obj);
        else
            System.out.println("Aluno não encontrado");
        pausa();

    }

    public static void pausa() throws Exception {
        System.out.println("\nPressione ENTER para continuar ...");
        console.nextLine();
    }

}
