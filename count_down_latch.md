## Count Down Latch
- This is used to synchronize one or more tasks by forcing them to wait for the completion of a set of operations being performed by other tasks.
- You give an initial count to a `CountDownLatch` object, and any task that calls `await()` on that object will block until the count reaches 0.
- Other tasks may call `countDown()` on the object to reduce the count,
  - presumably when a task finishes its job.
  - The count cannot be reset
  - If you need a version that resets the count you can use a `CyclicBarrier` instead.
  - The tasks that call `await()` are blocked until the count reaches zero.
  - Tasks should be independently solvable.
---