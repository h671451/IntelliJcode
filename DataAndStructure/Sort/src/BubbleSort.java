import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array){
//        int i = 0;
//        int firstIndex = 0;
//        int secondIndex = i+1;
//        int temp = array[firstIndex];
//        while (i< array.length){
//            if (i<i+1){
//                i++;
//            }else{
//                temp = array[firstIndex];
//                array[firstIndex] = array[secondIndex];
//                array[secondIndex] = temp;
//                i++;
//            }
//        }
        for(int i = array.length -1; i>0; i-- ){
            for(int j = 0; j< i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        bubbleSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }
}
