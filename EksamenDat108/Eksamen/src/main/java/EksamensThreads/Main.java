package EksamensThreads;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rulletekst thread1 = new Rulletekst("Heia Brann!");

        thread1.start();
        Scanner lesT = new Scanner(System.in);

        while (true){
            System.out.println("Skrin inn ny teksts");
            String nyTekst = lesT.nextLine();
            thread1.setTekst(nyTekst);
        }
    }
}
