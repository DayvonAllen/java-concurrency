## Methods
- `sleep()` - puts a thread to sleep for a specified time 
  - causes thread to cease execution for temporary period of time.
  - Exception: `InterruptedException`
- `join()` - allows us to wait for a thread to finish before proceeding to the next lines of code
  - Exception: `InterruptedException`
- `start()` - creates a new thread and starts it.
- Methods that can be used and called from synchronized methods or blocks exclusively:
  - `wait()` - it means that a thread is going to release the lock for another thread and wait for the thread to call `notify()`
    - Puts the thread in a `WAITING` state.
  - `notify()` - lets a thread know that it can acquire the lock.
  - Those two methods can only be used when threads are using the same intrinsic lock
---
  
## Wait vs Sleep Method
``` 
you call wait on the Object while on the other hand you call sleep on the Thread itself

wait can be interrupter (this is why we need the InterruptedException) while on the other hand sleep can not

wait (and notify) must happen in a synchronized  block on the monitor object whereas sleep does not

sleep operation does not release the locks it holds while on the other hand wait releases the lock on the object that wait() is called on
```
---