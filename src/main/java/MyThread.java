import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyThread {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<CallableTask> tasks = new ArrayList<>();
        List<Future<Integer>> futuresTasks;

        for (int i = 0; i < 3; i++) {
            tasks.add(new CallableTask());
        }
        futuresTasks = executor.invokeAll(tasks);
        for (int i = 0; i < futuresTasks.size(); i++) {
            try {
                System.out.printf("Количество сообщений напечатаное задачей №%d = %d.\n", i + 1, futuresTasks.get(i).get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        try {
            System.out.println("Количество сообщений напечатаное самой быстрой задачей = " + executor.invokeAny(tasks));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

