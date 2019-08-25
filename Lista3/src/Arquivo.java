
import java.io.*;

public class Arquivo {

	String nomeArquivo;

	Arquivo(String nomeArquivo){
		this.nomeArquivo = nomeArquivo;
	}

	Arquivo(){
		this.nomeArquivo = "";
	}


	public void salvarRegistro(Registro r) throws IOException{
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "rw");
		file.seek(file.length());
		file.writeInt(r.getByteArray().length);
		file.write(r.getByteArray());
		file.close();
	}

	public void listarArquivo() throws IOException{
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "r");

		int cont = 0;
		while (cont < file.length()) {

			int size = file.readInt();
			byte b [] = new byte[size];
			file.read(b);

			Aluno a = new Aluno();
			a.setByteArray(b);
			a.print();

			cont = cont + 4 + size + 4;

		}
		file.close();
	}
	public Aluno pesquisaArquivo(String nome) throws IOException{
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "r");

		int cont = 0;
		while (cont < file.length()) {

			//Obtém o tamanho do registro (primeiros 4 bytes)
			int size = file.readInt();

			//Obtem os demais bytes (4 do código + restantes ref ao Nome)
			byte b [] = new byte[size];
			file.read(b); //Armazena em b

			Aluno a = new Aluno();
			a.setByteArray(b); //carregaDados
			//a.print();


			if (a.getNome().trim().equals(nome)) {
				file.close();
				return a;
			}
			cont = cont + 4 + size + 4;

		}
		file.close();
		return null;
	}
	public Aluno pesquisaTernario(int codigo) throws IOException {

		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "rw");
		file.seek(0);

		int tam_registro_bytes = 4 + 4 + Aluno.TAM_NOME;
		int numRegistros = (int)file.length() / tam_registro_bytes;

		long pos_inicial = 0;
		long pos_final = file.length() - tam_registro_bytes;
		long pos_meio;

		while (pos_inicial <= pos_final) {

			//Calcula a posição do meio
			pos_meio = (pos_inicial + pos_final) / 2;

			//Caso o arquivo tenha numero par ou ímpar de elementos, deve-se ajusta o ponteiro para não cair no meio do registro
			if (pos_meio % tam_registro_bytes != 0)
				pos_meio = pos_meio + (pos_meio % tam_registro_bytes);

			file.seek(pos_meio);

			//Ler o registro na posição definida
			int size = file.readInt();
			byte b [] = new byte[size];
			file.read(b);

			//Carrega o objeto da classe aluno e verifica o código
			Aluno a = new Aluno();
			a.setByteArray(b);
			//System.out.print("(" + a.getCodigo() + ")");
			if (a.getCodigo() == codigo) {

				file.close();
				return a;

				//divide ao meio
			} else if (codigo < a.getCodigo())
				pos_final = pos_meio - tam_registro_bytes;
			else
				pos_inicial = pos_meio + tam_registro_bytes;

		}

		return null;

	}

}
