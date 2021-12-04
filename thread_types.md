## Two Types Of Threads In Java
- `Daemon Thread`
- `Standard Thread` or `Worker Thread` or `User Thread`
- The JVM creates the threads
---

## Main Thread
- When a Java program starts the JVM creates a thread that begins running immediately(main thread) - this thread starts the main method.
- We can create child threads from the main thread.
- The main thread is the last thread to finish execution because it performs various shutdown operations.
---

## Daemon Threads
- They are intended as helper threads(ex. garbage collection)
- Daemon threads are low priority threads that run in the background to perform tasks such as garbage collection
- Usually we create daemon threads for I/O operations or services(smartphone services such as NFC or Bluetooth communication)
- Daemon threads are terminated by the JVM when all other worker threads are terminated(finish execution)
- The main difference between daemon threads and worker threads is worker threads are not terminated while daemon threads are interrupted by the JVM.
``` 
 // make a thread a daemon thread
 Thread t1 - new Thread(() -> System.out.println("I'm a daemon thread"));
 
 // this makes a thread a daemon thread instead of a User Thread.
 t1.setDaemon(true);
 
 // prints out whether the thread is a daemon thread or not
 System.out.println(t1.isDaemon());
 
 // start daemon thread
 t1.start();
```
---

## Worker Threads / User Thread / Standard Thread
- l
---