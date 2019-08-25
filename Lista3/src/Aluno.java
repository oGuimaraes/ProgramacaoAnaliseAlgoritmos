import java.io.*;

public class Aluno implements Registro {
	protected int codigo;
	private static int codigoStatico = 1;
	protected String nome;
	protected int idade;

	Aluno(){}

	public final static int TAM_NOME = 20;

	Aluno(String nome, int idade) throws IOException {
		this.nome = nome;
		this.codigo = codigoStatico++;
		this.idade = idade;
	}

	public int returnCodigoAutoIncrementavel() throws IOException {
		//RandomAccessFile file = new RandomAccessFile("Alunos.txt", "r");

		//Obtém o tamanho do registro (primeiros 4 bytes)
		//int size = file.readInt();

		//Obtem os demais bytes (4 do código + restantes ref ao Nome)
		//byte b [] = new byte[size];

		//file.read(b); //Armazena em b
		//System.out.println(size);
		//file.seek(0);
		//System.out.println("" + file.readUTF());
		return 2;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getString() {
		return "Codigo: " + codigo + "Nome: " + nome + "Idade: " + idade;
	}

	@Override
	public String toString() {
		return "Nome: " + nome.trim() + "\t\t\tCodigo: " + codigo + "\t\t\tIdade: " + idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static String getStringTamanhoFixo(String texto, int tamanho) {
		StringBuffer s1 = new StringBuffer(texto);
		s1.setLength(tamanho);
		return s1.toString();
	}

	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream registro = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(registro);
		saida.writeInt(codigo);
		saida.writeInt(idade);
		//Escreve Tamanho Fixo
		saida.write((getStringTamanhoFixo(nome,TAM_NOME)).getBytes());

		return registro.toByteArray();
	}

	public void setByteArray(byte[] b) throws IOException {
		ByteArrayInputStream registro = new ByteArrayInputStream(b);
		DataInputStream entrada = new DataInputStream(registro);
		codigo = entrada.readInt();
		idade = entrada.readInt();
		//nome = entrada.readUTF();
		nome = entrada.readLine();

	}

	public int compareTo(Object b) {
		return codigo - ((Aluno) b).getCodigo();
	}

	public Aluno clone() throws CloneNotSupportedException {
		return ((Aluno) super.clone());
	}

	public void print() {
		System.out.println(this.codigo + " " + this.nome);
	}
}
