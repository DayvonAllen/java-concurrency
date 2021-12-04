package sync;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object myCustomLock = new Object();
    private int value = 0;

    public void produce() throws InterruptedException {
        synchronized (myCustomLock) {

            while (true) {
                if(list.size() == UPPER_LIMIT) {

                    if(list.get(list.size() - 1) == 99){
                        break;
                    }

                    System.out.println("Waiting for removal of items...");
                    myCustomLock.wait();
                }
                else {
                    System.out.println("Adding: " + value);
                    list.add(value);
                    value++;

                    // notify will notify the other thread if it is in a waiting state
                    myCustomLock.notify();
                }
            }

            System.out.println("Producer is done");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (myCustomLock) {
            while (true) {
                if(list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for the insertion of items...");
                    myCustomLock.wait();
                } else if(list.get(list.size() - 1) == 95) {
                    System.out.println("Removing: " + list.remove(list.size() - 1));
                    break;
                }
                else {
                    System.out.println("Removing: " + list.remove(list.size() - 1));

                    // notify will notify the other thread if it is in a waiting state
                    myCustomLock.notify();
                }
            }
        }

        System.out.println("Consumer is done");
    }
}
