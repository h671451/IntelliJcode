package EksamensThreads;

public class fibRegning  extends Thread{

    final int N = 50;
    @Override
    public void run (){
        while(true){
            //long fibCount = fib(N);
            System.out.print("Beregner fib(" + N + "):");
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
