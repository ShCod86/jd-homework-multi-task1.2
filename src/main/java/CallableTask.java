import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int max = random.nextInt(6) + 1;
        int count = 0;
        for(int i = 0; i < max; i++) {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " Всем привет");
            count++;
        }
        return count;
    }
}
