import java.util.Arrays;
import java.util.Random;

public class Oppgave2 {

    public static void insertionSort(Integer[] arr) {
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

    public static void selectionSort(Integer[] arr) {
        for(int i= 0; i<arr.length; i++) {
            int minIndex = i;
            for(int j = i+1; j <arr.length; j++) {
                if(arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }

        }
    }



    public static Integer[] merge(Integer[] array1, Integer[] array2) {
        Integer[] combined = new Integer[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    public static Integer[] mergeSort(Integer[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length/2;
        Integer[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        Integer[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    private static void swap(Integer[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(Integer[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }



    private static void quickSortHelper(Integer[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex-1);
            quickSortHelper(array, pivotIndex+1, right);
        }
    }

    public static void quickSort(Integer[] array) {
        quickSortHelper(array, 0, array.length-1);
    }


    public static void main(String[] args) {

//        int n = 32000;
//        Integer[] arr = new Integer[n];
//        Random rand = new Random();
//        for (int i = 0; i < n; ++i) {
//            arr[i] = rand.nextInt(n);
//        }
//        long startTime = System.currentTimeMillis();
//        insertionSort(arr);
//        long endTime = System.currentTimeMillis();
//
//        long startTime2 = System.currentTimeMillis();
//        selectionSort(arr);
//        long endTime2 = System.currentTimeMillis();
//        // Perform insertion sort on arr1
//        System.out.println("InsertionSort");
//        System.out.println("N: " + n);
//        System.out.println("Antall målinger: ");
//        System.out.println("Målt tid: (InsertionSort): " + (endTime-startTime) + "ms" );
//        System.out.println("teoretisk tid: ");
        long seed = 1234;
        int n = 32000;
        Integer[] arr = new Integer[n];
        Integer[] arr2 = new Integer[n];
        Integer[] arr3 = new Integer[n];
        Integer[] arr4 = new Integer[n];
        Random random = new Random(seed);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
            arr2[i] = arr[i];
            arr3[i] = arr[i];
            arr4[i] = arr[i];
        }
        long startTime = System.currentTimeMillis();
        insertionSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Tid brukt INSERTION SORT: " + (endTime - startTime) + " ms");

        long startTime2 = System.currentTimeMillis();
        selectionSort(arr2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Tid brukt Selection Sort: " + (endTime2 - startTime2) + " ms");

        long startTime3 = System.currentTimeMillis();
        quickSort(arr3);
        long endTime3 = System.currentTimeMillis();
        System.out.println("Tid brukt QUICKSORT: " + (endTime3 - startTime3) + " ms");

        long startTime4 = System.currentTimeMillis();
        mergeSort(arr4);
        long endTime4 = System.currentTimeMillis();
        System.out.println("Tid brukt MERGESORT: " + (endTime4 - startTime4) + " ms");

        // Perform insertion sort on arr1
        System.out.println("SelectionSort" );
        System.out.println("N: " + n);
        System.out.println("Antall målinger: 3");
        System.out.println("Målt tid gjennomsnitt: " + 12312412  + "ms");
        System.out.println("teoretisk tid: ");



//        insertionSort(arr1);
//        System.out.println("Sorted arr1 using insertion sort:");
//        System.out.println(Arrays.toString(arr1));





// Vi hadde to inserton metoder der den første metoden flyttet ikke vi det minste elemente, og da tok metoden lengre tid å kjøre
        // i den andre metoden satt vi den minste elementet fremst før vi startet sortering og dette fikk koden til å kjøre raskere.
    }
}
