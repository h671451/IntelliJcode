package EksamensThreads;

public class eksamenh22 {
    public static void main(String[] args) {
        fibRegning thread1 = new fibRegning();

        thread1.start();
        while(thread1.isAlive()){
            thread1.start();
        }
    }
}
