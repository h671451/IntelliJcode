public class Main {
    public static void main(String[] args) {


        double vekstfaktor = 1.015;
        int antatllMND = 0;
        double y = 5000;
        double sluttverdi = 10000;



        for (int i = 0; y<sluttverdi; i++){
            y *= vekstfaktor;
            antatllMND = i;
            if(y > 10000){
                break;
            }

        }
        System.out.println("Det tar " + antatllMND + " månender før du har spart " + y);
    }
}