import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HeapSort {
    
    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && arr[esquerda] > arr[maior])
            maior = esquerda;

        if (direita < n && arr[direita] > arr[maior])
            maior = direita;

        if (maior != i) {
            int swap = arr[i];
            arr[i] = arr[maior];
            arr[maior] = swap;
            heapify(arr, n, maior);
        }
    }

    static void imprimirArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        HeapSort heapSort = new HeapSort();
        ArrayList<Integer> numeros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\TOPNET\\Desktop\\HOSPITAL\\dados500_mil.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.replace("[", "").replace("]", ""); // Remove colchetes
                for (String numero : linha.split(",\\s*")) {
                    numeros.add(Integer.parseInt(numero));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = numeros.stream().mapToInt(i -> i).toArray();

        System.out.println("Array original:");
        imprimirArray(arr);

        heapSort.sort(arr);

        System.out.println("Array ordenado:");
        imprimirArray(arr);
    }
}
