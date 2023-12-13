package Oppgave5;

import java.util.Random;

public class Oppgave5b {
    public static void main(String[] args) {
        Random random = new Random();
        int antallTre = 100;
        int antallNoder = 1023;
        int totalHeight = 0;
        int minHeight = Integer.MAX_VALUE; //En konstant som viser den maksimale veriden til datatypen int
        int maxHeight = Integer.MIN_VALUE; //En konstant som viser den minimale veriden til datatypen int
        int minTheoreticalHeight = (int) Math.ceil(Math.log(antallNoder + 1) / Math.log(2)) - 1; // finner teoretiske maksimumshoyden. Formelen: h = ceil(log2(n+1)) - 1
        int maxTheoreticalHeight = antallNoder - 1;

        for(int i = 0; i<antallTre; i++){
            BinarySearchTree<Integer> tre = new BinarySearchTree<>();
            for (int j = 0; j<antallNoder; j++){
                int nyNode = random.nextInt();
                tre.addTo(nyNode);
            }
            int hoyde = tre.height(); //finner hoyden
            totalHeight += hoyde;
            minHeight = Math.min(minHeight,hoyde);
            maxHeight = Math.max(maxHeight,hoyde);
        }
        double avgHeight = (double) totalHeight / antallTre;

        System.out.println("Antall Noder: " + antallNoder);
        System.out.println("Den minimale teoretiske høyden: " + minTheoreticalHeight);
        System.out.println("Den maksimale teoretiske høyden: " + maxTheoreticalHeight);
        System.out.println("Minste høyde i løpet av kjøringene: " + minHeight);
        System.out.println("Største høyde i løpet av kjøringene: " + maxHeight);
        System.out.println("Gjennomsnittlig høyde av alle kjøringene: " + avgHeight);
    }
}
