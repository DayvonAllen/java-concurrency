package sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();
    // the lock is bound by this condition
    // we need this because we cannot call wait() and notify() on this lock
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        // same as wait()
        condition.await();

        System.out.println("Producer method again...");

        // important we always have to release the lock
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        // We want to make sure we start with the producer()
        // so we make the thread sleep for 2 seconds
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method...");
        Thread.sleep(3000);

        // same as notify()
        condition.signal();

        // important we always have to release the lock
        lock.unlock();
    }
}
