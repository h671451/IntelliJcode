public class Oppgave3 {

    // denne algorytmen funker for både sortert og usortert tabell
    public static boolean linearSearch(int[] array, int value){
        for (int i = 0; i< array.length; i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int target){

        int lavest = 0;
        int hoyest = array.length-1;

        while (lavest <= hoyest){
            int median = lavest + (hoyest-lavest) / 2;
            int value = array[median];

            if(value < target ){
                lavest = median +1;
            } else if (value > target) {
                hoyest = median-1;
            } else {
                return true;
            }
        }

        return false;
    }



}
