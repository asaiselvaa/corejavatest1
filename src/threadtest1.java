import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class myrun1 implements Runnable {
    private int mark;
    public myrun1(int mark) {
        this.mark = mark;
    }
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.mark);//
    }
}
public class threadtest1 {
    public static void main(String[] abc) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(100);

        for (int m=1;m<=1000;m++) {
            myrun1 mrn = new myrun1(m);
            ex.execute(mrn);
        }
        ex.shutdown();
        ex.awaitTermination(4, TimeUnit.SECONDS);

        System.out.println("Finished!!");
    }
}
