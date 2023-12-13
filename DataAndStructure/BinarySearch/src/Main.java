import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int array [] = new int[100];
        int target = 42;
        for(int i = 0; i <array.length; i++){
            array[i] = i;
        }
        //int index = Arrays.binarySearch (array,target);
        int index = binarySearch (array,target);

        if(index == -1) {
            System.out.println(target + "not found");
        } else {
            System.out.println("Element found at: " + index);
        }

        System.out.print(f(2,5));



    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length-1;

        while ( low<= high){
            int middle = low + (high-low) / 2;
            int value = array[middle];

            System.out.println("middle" + value);
            if ( value < target) low = middle+1; //hvis verdien vi leter etter er mindre. så setter vi indeksen vår til midten +1
            else if ( value > target) high = middle -1; //hvis verdien vi leter etter er større. så setter vi høyeste indeksen til midten -1
            else return middle; // target found
        }
        return -1; //element not found
    }

    public static int f(int a, int b){
        if (b ==1){
            return a;
        } else {
            if (b % 2 == 0){
                int svar = f(a,b/2);
                return svar* svar;
            } else{
                return a * f(a,b-1);
            }
        }
    }

}


