package EksamensThreads;

import org.springframework.boot.Banner;

public  class Rulletekst  extends Thread{

    private Banner banner;

    public Rulletekst(String tekst){
        banner = new Banner(tekst);
    }

    public void setTekst(String text){
        banner.setText(text);
    }

    @Override
    public void run(){
        while(true){
            banner.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
