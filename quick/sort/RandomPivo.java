package quick.sort;

public class RandomPivo {
	public static void main(String[] args) {

		int quantidade = 1000000;
		int[] vetor = new int[quantidade];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}
		// System.out.println(Arrays.toString(vetor));
		long tempoInicial = System.currentTimeMillis();

		quicksort(vetor, 0, vetor.length - 1);

		long tempoFinal = System.currentTimeMillis();

		// System.out.println(Arrays.toString(vetor));
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

	}

	public static void troca(int[] vetor, int i, int j) {
		int temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
	}

	public static int separacao(int[] vetor, int inicio, int fim) {

		// Valor randomico
		int random = inicio + ((int) Math.random() * (vetor.length)) / (fim - inicio + 1);

		// nova posição do pivo
		int ultimo = fim;

		// Move o pivo para a direita
		troca(vetor, random, fim);
		fim--;

		while (inicio <= fim) {
			if (vetor[inicio] < vetor[ultimo])
				inicio++; 
			else {
				troca(vetor, inicio, fim);
				fim--;
			}
		}

		// Move o pivo para a posição correta
		troca(vetor, inicio, ultimo);

		return inicio;
	}

	public static void quicksort(int[] vetor, int inicio, int fim) {
		if (inicio >= fim)
			return;
		if (inicio < 0)
			return;
		if (fim > vetor.length - 1)
			return;

		int pivot = separacao(vetor, inicio, fim);
		quicksort(vetor, inicio, pivot - 1);
		quicksort(vetor, pivot + 1, fim);
	}
}
