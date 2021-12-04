package sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Task implements Runnable {
    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task Id: " + id + " \nThread Id: " + Thread.currentThread().getName());
        long duration = (long) (Math.random() * 5);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();

            // we need this to shutdown all threads even if they are sleeping
            Thread.currentThread().interrupt();
        }
    }
}

class Work implements Callable<Integer> {
    private final int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        return id + 1;
    }
}


public class MyExecutor {

    public static void createSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i));
        }

        // we prevent the executor from executing more tasks
        executorService.shutdown();

        // terminate actual running tasks
        try {
            // wait one second for tasks to shutdown, if not we force a shutdown with shutdownNow();
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                // if we want to wait for all tasks to finish then we don't have to put shutdownNow
//                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }

    public static void createFixedThreadExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i));
        }

        // we prevent the executor from executing more tasks
        executorService.shutdown();

        // terminate actual running tasks
        try {
            // wait one second for tasks to shutdown, if not we force a shutdown with shutdownNow();
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                // if we want to wait for all tasks to finish then we don't have to put shutdownNow
//                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }

    public static void createFutureFixedThreadExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> myNums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<Integer> future = executorService.submit(new Work(i));
            myNums.add(future);
        }

        for (Future<Integer> num : myNums) {
            try {
                System.out.println(num.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        // we prevent the executor from executing more tasks
        executorService.shutdown();

        // terminate actual running tasks
        try {
            // wait one second for tasks to shutdown, if not we force a shutdown with shutdownNow();
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                // if we want to wait for all tasks to finish then we don't have to put shutdownNow
//                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }

    public static void createScheduledThreadExecutor() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 5; i++) {
            // 2nd arg initial delay, 3rd arg how often to call, 4th arg time units
            executorService.scheduleAtFixedRate(new Task(i), 1000, 2000, TimeUnit.MILLISECONDS);
        }
    }
}
