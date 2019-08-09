import java.util.Random;

/*
 *  Construa um algoritimo em Java que preencha um vetor de tamanho N com valore inteiros positivos
 *  de 0 a 9. Em seguida armazene em um segundo vetor de 10 posicoes as quantidades de cada tipo de
 *  elemento do primeiro vetor.
 */

public class Exercicio1 {

    public static int[] criaVetor(int tamVetor) {
        int[] vetorGeral = new int[tamVetor];
        Random random = new Random();

        for (int i = 0; i < tamVetor; i++) {
            vetorGeral[i] = random.nextInt(10);
        }
        return vetorGeral;
    }

    public static void printaVetor(int[] vetor) {
        int tamVetor = vetor.length;
        System.out.print("\nVetor = [");

        for (int i = 0; i < tamVetor; i++) {
            System.out.print(vetor[i] + ",");
        }
        System.out.print("]");
    }

    public static int[] contaQuantidadeIntVetor(int[] vetor){
        int vetorContador[] = {0,0,0,0,0,0,0,0,0,0};

        for (int i = 0; i < vetor.length; i++) {
            vetorContador[vetor[i]]++;
        }

        return vetorContador;
    }

    public static void main(String[] args) {

        int[] vetorGeral = criaVetor(50);
        printaVetor(vetorGeral);
        int[] vetorContador = contaQuantidadeIntVetor(vetorGeral);
        printaVetor(vetorContador);

    }
}