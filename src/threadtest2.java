import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class myrun2 implements Callable {
    private int mark;
    public myrun2(int mark) {
        this.mark = mark;
    }
    public LocalDateTime call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.mark);
        return LocalDateTime.now();
    }
}
public class threadtest2 {
    public static void main(String[] abc) throws InterruptedException, ExecutionException {
        ExecutorService ex = Executors.newFixedThreadPool(100);
        List<Future> flist = new ArrayList<>();

        for (int m = 1; m <= 1000; m++) {
            myrun2 mrn = new myrun2(m);
            Future fob = ex.submit(mrn);
            flist.add(fob);
        }
        ex.shutdown();

        if (true) {
            for (Future f : flist) {
                System.out.println(f.get());
            }
        }
        System.out.println("Finished!!");
    }
}
