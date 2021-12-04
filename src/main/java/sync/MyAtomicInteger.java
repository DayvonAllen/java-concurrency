package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger {
    public static final AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
        for (int i = 0; i < 10000; i++)
            counter.getAndIncrement();
    }
}
