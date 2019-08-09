import java.util.Random;

/*
* Faca um algoritimo que realize uma busca binaria de um elemento
* em um vetor ordenado. Apresente uma versao do algoritimo.
* Ordene o vetor utilizando algum metodo de ordenacao. Contabilize
* tempo necessario utilizado para ordenar. Crie um METODO para ordenar.
*/

public class Exercicio2 {

    public static int[] criaVetor(int tamVetor) {
        int[] vetorGeral = new int[tamVetor];
        Random random = new Random();

        for (int i = 0; i < tamVetor; i++) {
            vetorGeral[i] = random.nextInt(99999);
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

    public static int[] ordenaVetorCrescente(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            for (int j = 0; j < i; j++) {
                if (vetor[i] < vetor[j]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
        return vetor;
    }

    public static int encontra(int[] vetor, int K) {
        return encontraRecursivo(vetor, K, 0, vetor.length);
    }

    public static int encontraRecursivo(int[] vetor, int K, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (vetor == null || inicio > fim)
            return -1;
        if (vetor[meio] == K)
            return vetor[meio];
        if (vetor[meio] < K)
            return encontraRecursivo(vetor, K, meio + 1, fim);
        else
            return encontraRecursivo(vetor, K, inicio, fim - 1);
    }

    public static void main (String[]args){

        int[] vetorDesordenado = criaVetor(10000);
        printaVetor(vetorDesordenado);

        long tempoInicial = System.currentTimeMillis();
        int[] vetorOrdenado = ordenaVetorCrescente(vetorDesordenado);
        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = (tempoFinal - tempoInicial);

        System.out.println("\nTempo de execução da ordenação: " + tempoExecucao + "ms");
        printaVetor(vetorOrdenado);
        System.out.println("\nChave procurada K = " + vetorOrdenado[0] + " | Chave encontrada = " + encontra(vetorOrdenado, vetorOrdenado[0]));
    }

}