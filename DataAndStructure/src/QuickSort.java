import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex){
//        int pivot = array[0];
//
//        int bytte = pivot;
//        for (int i = 0; i< array.length-1; i++){
//            if (pivot<i){
//                bytte = array[i-1];
//                swap(array,bytte,i);
//            }
//        }
//        swap(array,bytte,pivot);
//
//        return bytte;
        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i<=endIndex; i++){
            if (array[i] < array[pivotIndex]){
               swapIndex++;
                swap(array,swapIndex,i);
            }
        }
        swap(array,pivotIndex,swapIndex);
        return swapIndex;
    }

    public static void quickSort(int[] array, int left, int right){
        if (left<right){
            int pivotIndex = pivot(array,left,right);
            quickSort(array,left,pivotIndex-1);
            quickSort(array,pivotIndex+1,right);
        }




    }

    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        quickSort(myArray,0,6);

        System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7]

         */

    }
}
