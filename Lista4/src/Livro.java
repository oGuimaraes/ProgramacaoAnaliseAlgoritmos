import java.io.*;

public class Livro implements Entidade {
    protected int    id;
    protected String titulo;
    protected String autor;
    protected float  preco;
    
    public Livro(int c, String t, String a, float p) {
        this.id = c;
        this.titulo = t;
        this.autor = a;
        this.preco = p;
    }
    public Livro() {
        this.id = 0;
        this.titulo = "";
        this.autor = "";
        this.preco = 0f;        
    }
    
    public void setId(int c) {
        this.id = c;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String toString() {
        return "\nCódigo: " + this.id +
               "\nTítulo: " + this.titulo +
               "\nAutor.: " + this.autor +
               "\nPreço.: " + String.format("%.2f", this.preco);
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( dados );
        saida.writeInt(this.id);
        saida.writeUTF(this.titulo);
        saida.writeUTF(this.autor);
        saida.writeFloat(this.preco);
        return dados.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readInt();
        this.titulo = entrada.readUTF();
        this.autor = entrada.readUTF();
        this.preco = entrada.readFloat();
    }


}
