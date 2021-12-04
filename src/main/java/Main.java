import sync.*;

import static sync.NaiveSync.synchronizedThreadsExample;
import static thread.MyThread.daemonThreadsExample;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//         daemonThreadsExample();
//        synchronizedThreadsExample();
//        WaitAndNotify waitAndNotify = new WaitAndNotify();
//        MyReentrantLock processor = new MyReentrantLock();
//
//        Thread t1 = new Thread(() -> {
//            try {
//                processor.produce();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
//                processor.consume();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        t1.start();
//        t2.start();

//        Thread t1 =  new Thread(MyAtomicInteger::increment, "first-child-thread");
//        Thread t2 = new Thread(MyAtomicInteger::increment, "second-child-thread");
//
//        try {
//            t1.start();
//            t2.start();
//
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(MyAtomicInteger.counter);
//        MySemaphore.createSemaphore();
//        MyExecutor.createSingleThreadExecutor();
//        MyExecutor.createFutureFixedThreadExecutor();
//        MyExecutor.createScheduledThreadExecutor();
//        MyCountDownLatch.createCountDownLatch();
        MyCyclicBarrier.createCyclicBarrier();
    }

}
