import sync.MyReentrantLock;
import sync.Processor;
import sync.WaitAndNotify;

import static sync.NaiveSync.synchronizedThreadsExample;
import static thread.MyThread.daemonThreadsExample;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//         daemonThreadsExample();
//        synchronizedThreadsExample();
//        WaitAndNotify waitAndNotify = new WaitAndNotify();
        MyReentrantLock processor = new MyReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

}
