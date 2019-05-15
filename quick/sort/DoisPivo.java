package quick.sort;

import java.io.IOException;

public class DoisPivo {

	public static void main(String[] args) throws IOException {

		int quantidade = 1000000;
		int[] vetor = new int[quantidade];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}
		// System.out.println(Arrays.toString(vetor));
		long tempoInicial = System.currentTimeMillis();

		doisPivoQuicksort(vetor, 0, vetor.length - 1, 3);

		long tempoFinal = System.currentTimeMillis();
		// System.out.println(Arrays.toString(vetor));
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

	}

	private static void troca(int[] a, int i, int j) {
		int auxilio = a[i];
		a[i] = a[j];
		a[j] = auxilio;
	}

	private static void doisPivoQuicksort(int[] a, int esquerda, int direita, int div) {
		int len = direita - esquerda;
		if (len < 30) { // insertion sort para arrays pequenos
			for (int i = esquerda + 1; i <= direita; i++) {

				for (int j = i; j > esquerda && a[j] < a[j - 1]; j--) {
					troca(a, j, j - 1);
				}
			}
			return;
		}
		int third = len / div;
		// meios
		int m1 = esquerda + third;
		int m2 = direita - third;
		if (m1 <= esquerda) {
			m1 = esquerda + 1;
		}
		if (m2 >= direita) {
			m2 = direita - 1;
		}
		if (a[m1] < a[m2]) {
			troca(a, m1, esquerda);
			troca(a, m2, direita);
		} else {
			troca(a, m1, direita);
			troca(a, m2, esquerda);
		}
		// pivos
		int pivo1 = a[esquerda];
		int pivo2 = a[direita];
		// posicoes
		int menor = esquerda + 1;
		int maior = direita - 1;
		// ordenacao
		for (int k = menor; k <= maior; k++) {
			if (a[k] < pivo1) {
				troca(a, k, menor++);
			} else if (a[k] > pivo2) {
				while (k < maior && a[maior] > pivo2) {
					maior--;
				}
				troca(a, k, maior--);
				if (a[k] < pivo1) {
					troca(a, k, menor++);
				}
			}
		}
		// trocas
		int dist = maior - menor;
		if (dist < 13) {
			div++;
		}
		troca(a, menor - 1, esquerda);
		troca(a, maior + 1, direita);
		// subarrays
		doisPivoQuicksort(a, esquerda, menor - 2, div);
		doisPivoQuicksort(a, maior + 2, direita, div);

		// comparacoes
		if (dist > len - 13 && pivo1 != pivo2) {
			for (int k = menor; k <= maior; k++) {
				if (a[k] == pivo1) {
					troca(a, k, menor++);
				} else if (a[k] == pivo2) {
					troca(a, k, maior--);
					if (a[k] == pivo1) {
						troca(a, k, menor++);
					}
				}
			}
		}
		
		if (pivo1 < pivo2) {
			doisPivoQuicksort(a, menor, maior, div);
		}
	}
}
