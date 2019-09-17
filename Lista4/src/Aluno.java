import java.io.*;

public class Aluno implements Entidade {
    protected int id;
    protected String nome;
    protected int idade;
    protected String curso;

    @Override
    public void setId(int c) {
        this.id = c;
    }

    public Aluno(){
        this.nome = "";
        this.idade = 0;
        this.curso = "";
    }

    public Aluno(int c, String nome, int idade, String curso) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( dados );
        saida.writeInt(this.id);
        saida.writeUTF(this.nome);
        saida.writeInt(this.idade);
        saida.writeUTF(this.curso);
        return dados.toByteArray();
    }

    @Override
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readInt();
        this.nome = entrada.readUTF();
        this.idade = entrada.readInt();
        this.curso = entrada.readUTF();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return id + "." + "\t\t\t" + nome + "\t\t\tIdade: " + idade + "\t\t\tCurso: " + curso;
    }
}
