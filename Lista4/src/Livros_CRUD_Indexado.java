/*
 * Exemplo da criação de um CRUD simples de livros
 * Arquivo SEM índice
 * Algoritmos e Estruturas de Dados III
 * Marcos Kutova
 */

import java.util.Scanner;

public class Livros_CRUD_Indexado {

    private static Scanner console = new Scanner(System.in);
    private static ArquivoIndexado<Livro> arqLivros;

    /**
     * Método principal, cujo objetivo é criar uma interface para o usuário
     */
    public static void main(String[] args) {

        try {

            arqLivros = new ArquivoIndexado<>(Livro.class.getConstructor(), "livros.db", "livros.idx");
            
            // menu
           int opcao;
           do {
               System.out.println("\n\nGESTÃO DE LIVROS");
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
                   case 1: listarLivros(); break;
                   case 2: incluirLivro(); break;
                   case 3: alterarLivro(); break;
                   case 4: excluirLivro(); break;
                   case 5: buscarLivro(); break;

                   case 0: break;
                   default: System.out.println("Opção inválida");
               }
               
           } while(opcao!=0);
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    

   public static void listarLivros() throws Exception {
       
       Object[] obj = arqLivros.listar();
       
       System.out.println("\nLISTA DE LIVROS");
       for(int i=0; i<obj.length; i++) {
           System.out.println((Livro)obj[i]);
       }
       pausa();
       
   }
   
   public static void incluirLivro() throws Exception {
       
       String titulo;
       String autor;
       float  preco;
       
       System.out.println("\nINCLUSÃO DE LIVRO");
       System.out.print("Título: ");
       titulo = console.nextLine();
       System.out.print("Autor: ");
       autor = console.nextLine();
       System.out.print("Preço: ");
       preco = Float.parseFloat(console.nextLine());
       
       System.out.print("\nConfirma inclusão? ");
       char confirma = console.nextLine().charAt(0);
       if(confirma=='s' || confirma=='S') {
           Livro obj = new Livro(-1, titulo, autor, preco);
           int id = arqLivros.incluir(obj);
           System.out.println("Livro incluído com ID: "+id);
       }

       pausa();
   }

   
   public static void alterarLivro() throws Exception {
       
       System.out.println("\nALTERAÇÃO DE LIVRO");

       int id;
       System.out.print("ID do livro: ");
       id = Integer.valueOf(console.nextLine());
       if(id <=0) 
           return;
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscar(id))!=null ) {
            System.out.println(obj);
            
            String titulo;
            String autor;
            float  preco;
            
            System.out.print("\nNovo título: ");
            titulo = console.nextLine();
            System.out.print("Novo autor: ");
            autor = console.nextLine();
            System.out.print("Novo preço: ");
            String auxPreco = console.nextLine();
            if(auxPreco.compareTo("")==0)
                preco=-1f;
            else
                preco = Float.parseFloat(auxPreco);

            if(titulo.length()>0 || autor.length()>0 || preco>=0) {
                System.out.print("\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='s' || confirma=='S') {

                obj.titulo = (titulo.length()>0 ? titulo : obj.titulo);
                obj.autor = (autor.length()>0 ? autor : obj.autor);
                obj.preco = (preco>=0?preco:obj.preco);

                if( arqLivros.alterar(obj) ) 
                        System.out.println("Livro alterado.");
                    else
                        System.out.println("Livro não pode ser alterado.");
                }
            }
       }
       else
           System.out.println("Livro não encontrado");
       pausa();
       
   }
  
   
   public static void excluirLivro() throws Exception {
       
       System.out.println("\nEXCLUSÃO DE LIVRO");

       int id;
       System.out.print("ID do livro: ");
       id = Integer.valueOf(console.nextLine());
       if(id <=0) 
           return;
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscar(id))!=null ) {
            System.out.println(obj);
            
            System.out.print("\nConfirma exclusão? ");
            char confirma = console.nextLine().charAt(0);
            if(confirma=='s' || confirma=='S') {
                if( arqLivros.excluir(id) ) {
                    System.out.println("Livro excluído.");
                }
            }
       }
       else
           System.out.println("Livro não encontrado");
       pausa();
       
   }
   
   
   public static void buscarLivro() throws Exception {
       
       System.out.println("\nBUSCA DE LIVRO POR CÓDIGO");
       
       int codigo;
       System.out.print("Código: ");
       codigo = Integer.valueOf(console.nextLine());
       if(codigo <=0) 
           return; 
       
       Livro obj;
       if( (obj = (Livro)arqLivros.buscar(codigo))!=null )
           System.out.println(obj);
       else
           System.out.println("Livro não encontrado");
       pausa();
       
   }

    public static void pausa() throws Exception {
        System.out.println("\nPressione ENTER para continuar ...");
        console.nextLine();
    }
    

}
