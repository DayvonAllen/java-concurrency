package sync;

import java.util.Random;
import java.util.concurrent.*;

class BarrierWorker implements Runnable {
    private int id;
    private CyclicBarrier barrier;
    private Random random;

    public BarrierWorker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.barrier = cyclicBarrier;
        this.random = new Random();
    }

    private void doWork() {
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("All threads are done");
    }

    @Override
    public void run() {
        System.out.println("Thread: " + this.id);
        doWork();
    }
}
public class MyCyclicBarrier {

    public static  void createCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 5; i++){
            executorService.execute(new BarrierWorker(i, cyclicBarrier));
        }

        executorService.shutdown();
    }
}
