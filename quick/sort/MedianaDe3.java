package quick.sort;

public class MedianaDe3 {
	public static void main(String[] args) {
		int quantidade = 1000000;
		int[] vetor = new int[quantidade];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}
		// System.out.println(Arrays.toString(vetor));
		long tempoInicial = System.currentTimeMillis();

		quickSort(vetor, 0, vetor.length - 1);
		
		long tempoFinal = System.currentTimeMillis();
		// System.out.println(Arrays.toString(vetor));
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
	}

	public static void quickSort(int[] intArray, int esquerda, int direita) {
		int size = direita - esquerda + 1;
		if (size <= 3)
			manualSort(intArray, esquerda, direita);
		else {
			double median = mediana3(intArray, esquerda, direita);
			int partition = separar(intArray, esquerda, direita, median);
			quickSort(intArray, esquerda, partition - 1);
			quickSort(intArray, partition + 1, direita);
		}
	}

	public static int mediana3(int[] intArray, int esquerda, int direita) {
		int centro = (esquerda + direita) / 2;

		if (intArray[esquerda] > intArray[centro])
			troca(intArray, esquerda, centro);

		if (intArray[esquerda] > intArray[direita])
			troca(intArray, esquerda, direita);

		if (intArray[centro] > intArray[direita])
			troca(intArray, centro, direita);

		troca(intArray, centro, direita - 1);
		return intArray[direita - 1];
	}

	public static void troca(int[] intArray, int dex1, int dex2) {
		int temp = intArray[dex1];
		intArray[dex1] = intArray[dex2];
		intArray[dex2] = temp;
	}

	public static int separar(int[] intArray, int esquerda, int direita, double pivot) {
		int esquerdaPtr = esquerda;
		int direitaPtr = direita - 1;

		while (true) {
			while (intArray[++esquerdaPtr] < pivot)
				;
			while (intArray[--direitaPtr] > pivot)
				;
			if (esquerdaPtr >= direitaPtr)
				break;
			else
				troca(intArray, esquerdaPtr, direitaPtr);
		}
		troca(intArray, esquerdaPtr, direita - 1);
		return esquerdaPtr;
	}

	public static void manualSort(int[] intArray, int esquerda, int direita) {
		int size = direita - esquerda + 1;
		if (size <= 1)
			return;
		if (size == 2) {
			if (intArray[esquerda] > intArray[direita])
				troca(intArray, esquerda, direita);
			return;
		} else {
			if (intArray[esquerda] > intArray[direita - 1])
				troca(intArray, esquerda, direita - 1);
			if (intArray[esquerda] > intArray[direita])
				troca(intArray, esquerda, direita);
			if (intArray[direita - 1] > intArray[direita])
				troca(intArray, direita - 1, direita);
		}
	}

}