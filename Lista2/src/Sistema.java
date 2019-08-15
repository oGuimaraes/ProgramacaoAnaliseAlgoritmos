import java.io.*;

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

    public static void main(String[] args) {
        insereAluno();
    }
}
