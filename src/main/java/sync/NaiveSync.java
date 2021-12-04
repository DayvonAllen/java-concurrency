package sync;

public class NaiveSync {
    public static int counter = 0;

    // create custom objects to use as locks to get around the fact that each class only have 1 lock
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

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

//    not consider good practice to use synchronized keyword on methods, better to use it on blocks
//    public static synchronized void increment() {
//        counter++;
//    }
}
