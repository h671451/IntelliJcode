import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2){
        int [] combinedArray = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j< array2.length){
            if (array1[i] < array2[j]){
                combinedArray[index] = array1[i];
                index++;
                i ++;
            }else{
                combinedArray[index] = array2[j];
                index++;
                j++;
            }
        }

        while (i < array1.length){
            combinedArray[index] = array1[i];
            index++;
            i ++;
        }

        while (j < array2.length){
            combinedArray[index] = array2[j];
            index++;
            j++;
        }

        return combinedArray;
    }

    public static int [] mergeSorting (int[] array){

        if (array.length ==1) return array;
        int midIndex = array.length/2;
        int [] left = mergeSorting(Arrays.copyOfRange(array,0,midIndex));
        int [] right = mergeSorting(Arrays.copyOfRange(array,midIndex,array.length-1));

        return merge(left,right);

    }


}
