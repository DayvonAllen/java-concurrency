## Deadlocks
- It is a situation in which two or more competing actions are each waiting for the other to finish, and thus neither ever does.
- It occurs when two or more threads wait forever for a lock or resource held by another of the threads.
- OS Deadlock:
  - It occurs when a process or thread enters the waiting state because a resource requested is being held by another thread in the waiting process
    - which in turn is waiting for another resource held by another thread in the waiting process.
---
    
## Livelock
- A thread often acts in response to the action of another thread
- If the other thread's action is also a response to the action of another thread then livelock may arise
- Livelocked threads are unable to make further progress. However, the threads are not blocked
  - They are simply too busy responding to each other to resume work.
---
  
## How To Handle Deadlocks and Livelocks
- We should make sure that a thread does not block forever if it is unable to acquire a lock
  - this is why using the `Lock` interface you should use `tryLock()`
- We should make sure that each thread acquires the locks in the same order to avoid any cyclic dependency in lock acquisition.
- Livelock can be handled with the methods above and some randomness
  - threads retry acquiring locks at random intervals.
---