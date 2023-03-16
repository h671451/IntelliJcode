import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] array1, int [] array2){
        int [] combinedA = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int indeks = 0;
        while(i < array1.length && j < array2.length){
            if (array1[i]<array2[j]){
                combinedA[indeks] = array1[i];
                indeks++;
                i++;
            } else{
                combinedA[indeks] = array2[j];
                indeks++;
                j++;
            }
        }

        while(i < array1.length){
            combinedA[indeks] = array1[i];
            i++;
            indeks++;
        }

        while(j < array2.length){
            combinedA[indeks] = array2[j];
            j++;
            indeks++;
        }

        return combinedA;
    }

    public static int[] mergeSort(int[] array){
        if(array.length == 1) return array;

        int midIndex = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array,0,midIndex));
        int[] right = mergeSort( Arrays.copyOfRange(array,midIndex,array.length));

        return merge(left,right);
    }

    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]

            Sorted Array: [1, 2, 3, 4]

         */

    }



}
