import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array1 = {1,3,7,8};
        int [] array2 = {2,4,5,6,9};
        System.out.print(Arrays.toString(MergeSort.merge(array1,array2)));
    }
}