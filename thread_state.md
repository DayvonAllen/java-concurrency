## Thread States In Java
- `NEW` - when we instantiate a thread it is in this state until we start it
  - method: `start()`
- `RUNNABLE` - after we have started the thread, the thread is executing its task in this state
- `WAITING` - When a thread is waiting: for example for another thread to finish its task
  - When other threads signals then this thread goes back to the `RUNNABLE` state
    - Methods: `wait()` and `sleep()`
- `DEAD` - after the thread finishes its task.
---