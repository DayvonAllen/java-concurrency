package sync;

public class WaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Running in the produce method again");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("Running the consume method...");
            notify();
            // it is not going to release the lock immediately after the call, we can execute more code here.
            // once it finishes this sync block, it will notify the thread that is waiting
        }
    }
}
