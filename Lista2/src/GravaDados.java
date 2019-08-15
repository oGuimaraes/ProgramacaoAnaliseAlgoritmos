import java.io.FileOutputStream;
import java.io.PrintStream;

public class GravaDados {
	
	public static String getStringTamanhoFixo(String texto, int tamanho) {
		StringBuffer s1 = new StringBuffer(texto);
		s1.setLength(tamanho);
		return s1.toString();
	}
	
	public static void main(String[] args) {
		
		try {
			
			//Define o nome do arquivo a ser trabalhado
			System.out.print("Informe o nome do Arquivo a ser gravado: ");
			String nomeArquivo = Teclado.readLine();			
			
			//Objetos utilizados na manipula��o do arquivo e seus dados
			FileOutputStream arqSaida = new FileOutputStream(nomeArquivo);
			PrintStream saida = new PrintStream(arqSaida);
			
			System.out.print("Informe o numero de registros a serem gravados: ");
			int numRegistros = Teclado.readInt();			
			
			//Adiciona os registros desejados
			for(int i=0;i<numRegistros;i++) {
				System.out.print("Informe o codigo de pessoa: ");
				int codigo = Teclado.readInt();
				
				System.out.print("Nome: ");
				String nomePessoa = Teclado.readLine();

                System.out.print("Idade: ");
                int idadePessoa = Teclado.readInt();
				
				String linha = codigo + " " + nomePessoa + " " + idadePessoa;
				saida.println(linha);

			}

			saida.flush();
			saida.close();
			arqSaida.close();
			
			System.out.println("Dados Gravados com sucesso");
			
		}
		catch(Exception e) { //Tratamento generico da excessao ocorrida
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}
		
	}
}
