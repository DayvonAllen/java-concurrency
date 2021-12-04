## Memory Management
- There are processes and threads(light-weight processes)
  - The typical difference is that threads(of the same process) run in a shared memory space, while processes run in separate memory spaces.
- Stack Memory(small and fast) - the local variables and method arguments as well as method calls are stored on the stack. 
- Heap Memory(big and slow) - objects are stored on the heap memory and live as long as it is referenced from somewhere in the application
  - The heap memory is the main memory or RAM.
- Every thread has its own stack memory but all threads share the heap memory(shared memory space).
- The main purpose of synchronization is the sharing of resources without interference using mutual exclusion(Mutex).
- Threads cannot access each other's local variables because they are stored on the individual thread's stack
  - However, all threads are using the same heap memory(main memory / RAM), so they are working with the same exact objects on the heap(can lead to data race if synchronization is not used)
---

## Synchronization
- Makes sure that only a single thread can perform operations on shared data in memory at once to prevent data races
- Data race occurs when multiple threads are updating a value or object and causes the data to be out of sync
  - because some threads might be working with an old version of the value or object because another thread has already changed it
  - This causes for the output to be non-deterministic(unpredictable)
- We can use the `synchronized` keyword on methods to make sure that only one thread can execute the method at a time. 
- Whenever we use the `synchronized` keyword then the intrinsic lock for the class.
- It's not considered good practice to use the synchronized keyword on methods.
- We should use synchronized blocks
- `Intrinsic Lock` or `Monitor Lock` - every object or class in java has an intrinsic lock.
  - A thread that needs exclusive and consistent access to an object's fields has to acquire the object's intrinsic lock before accessing them
  - When the thread is done, it releases the intrinsic lock so other threads can access the object's fields.
  - Because of the monitor lock, no two threads can execute the same synchronized method at a time.
  - A thread owns the intrinsic lock between the time it acquires the lock, and it releases the lock.
  - As long as one thread owns an intrinsic lock, no other thread can acquire the same lock.
  - The other threads will block when attempting to acquire the lock.
  - The problem is that every object has a single monitor lock
    - If we have two independent `synchronized` methods than the threads have to wait for each other to release the lock.
    - Therefore, you should have at most one `synchronized` methods in a class.
``` 
  public static int counter = 0;
  
  // instance sync method
  public synchronized void increment() {
    counter++;
  }
  
  public void increment2() {
    // instance sync block
    synchonized(this) {
      counter++;
    }
  }
  
  This is called object level locking because we get the monitor lock(intrinsic lock) associated with the object itself.
```

``` 
  public static int counter = 0;
  
  // static sync method
  public static synchronized void increment() {
    counter++;
  }
  
  public static void increment2() {
    // static sync block
    synchonized(<ClassName>.class) {
      counter++;
    }
  }
  
  This is called class level locking because we get the monitor lock(intrinsic lock) associated with the class itself.
```
- Re-entrant synchronization:
``` 
So a thread cannot acquire a lock owned by another thread. But a given thread can acquire a lock that it already owns. 
Allowing a thread to acquire the same lock more than once is called re-entrant synchronization, 
and this is exactly what is happening in Python when using RLocks- the same thread may acquire the lock more than once.

For example: let's consider recursive method calls. 
If a given thread calls a recursive and synchronized method several times then it is fine (note that in this case the same thread "enters" the synchronized block several times).
There will be no deadlock because of re-entrant synchronization.

 
```
---