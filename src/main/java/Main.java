public class Main {
    public static int counter = 0;

    // create custom objects to use as locks to get around the fact that each class only have 1 lock
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


    public static void main(String[] args) {
        // daemonThreadsExample();
        synchronizedThreadsExample();
    }

    public static void daemonThreadsExample() {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    System.out.println("Daemon thread is working..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Worker thread is terminating..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.setDaemon(true);

        // this daemon thread will be terminated by the JVM when the worker thread beneath it terminates.
        t1.start();
        t2.start();
    }

    public static void synchronizedThreadsExample() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                // Good practice: we only synchronize blocks that are 100% necessary not methods
                synchronized (lock1) {
                    counter++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                // Good practice: we only synchronize blocks that are 100% necessary not methods
                synchronized (lock2) {
                    counter++;
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }

    // not consider good practice to use synchronized keyword on methods, better to use it on blocks
    //    public static synchronized void increment() {
    //        counter++;
    //    }

}
