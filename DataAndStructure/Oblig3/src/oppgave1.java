import java.util.Random;

public class oppgave1 {

//    public static void insertionSort(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            int temp = array[i];
//            int j = i - 1;
//            while (j > -1 && temp < array[j]) {
//                array[j+1] = array[j];
//                array[j] = temp;
//                j--;
//            }
//        }
//    }
    public static void insertionSort(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        int temp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = temp;
        for (int i = 1; i < arr.length; ++i) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    //Oppgave 1b
    public static void modifisertinsertionSort(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        
        int temp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = temp;

        for (int i = 2; i < arr.length; i+=2) {
            int j = i - 1;
            int key1 = arr[i-1];
            int key2 = arr[i];
            while (j >= 0 && arr[j] > key2) {
                arr[j + 2] = arr[j];
                arr[j + 1] = arr[j - 1];
                j = j - 2;
            }
            arr[j + 2] = key2;
            arr[j + 1] = key1;
        }

        if (arr.length % 2 == 0) {
            int j = arr.length - 2;
            int key1 = arr[arr.length - 2];
            int key2 = arr[arr.length - 1];
            while (j >= 0 && arr[j] > key2) {
                arr[j + 2] = arr[j];
                arr[j + 1] = arr[j - 1];
                j -= 2;
            }
            arr[j + 2] = key2;
            arr[j + 1] = key1;
        } else {
            int j = arr.length - 2;
            int key = arr[arr.length - 1];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 2;
            }
            arr[j + 1] = key;
    }
    }


    public static void main(String[] args) {
        int n = 200000;
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; ++i) {
            arr[i] = rand.nextInt(n);
        }
        long startTime = System.currentTimeMillis();
        insertionSort(arr);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " ms");

// Vi hadde to inserton metoder der den første metoden flyttet ikke vi det minste elemente, og da tok metoden lengre tid å kjøre
        // i den andre metoden satt vi den minste elementet fremst før vi startet sortering og dette fikk koden til å kjøre raskere.
    }
}

