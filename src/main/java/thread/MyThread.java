package thread;

public class MyThread {
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
}
