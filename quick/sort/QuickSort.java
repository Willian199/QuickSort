package quick.sort;

import java.io.IOException;

public class QuickSort {
	public static void main(String[] args) throws IOException {

		// Criar um vetor com 1 Milhão de posições
		int quantidade = 1000000;
		int[] vetor = new int[quantidade];

		// Gera numeros randomicos e aloca no vetor
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}

		// Pega o horário do sitema
		long tempoInicial = System.currentTimeMillis();

		/**
		 * Executa o metodo de ordenação passando 3 parametros
		 * 
		 * Vetor, posição inicial e posição final do vetor
		 *
		 */

		quickSort(vetor, 0, vetor.length - 1);

		long tempoFinal = System.currentTimeMillis();

		// Calcula o tempo que levou a execução
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

	}

	private static void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private static int separar(int[] vetor, int inicio, int fim) {
		// Pega o vetor na posição que veio de parametro
		int pivo = vetor[inicio];
		// Pega a segunda posição
		int i = inicio + 1;

		// Fica loop passando por todas as posições
		while (i <= fim) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[fim])
				fim--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[fim];
				vetor[fim] = troca;
				i++;
				fim--;
			}
		}
		vetor[inicio] = vetor[fim];
		vetor[fim] = pivo;
		return fim;
	}
}
