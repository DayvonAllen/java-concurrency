## Mutexes(Mutual Exclusion Objects)
- Mutual Exclusion is a property of concurrency control which is instituted for the purpose of preventing race conditions.
- Process synchronization plays an important role in maintaining the consistency of shared data(critical section problem)
- Mutex is very similar to a binary semaphore: while binary semaphore can be used as a mutex, a mutex is a more specific use-case
- A Lock is designed to enforce a mutual exclusion concurrency control policy.
- Mutex is a locking mechanism
- threads or processes have to acquire the lock on mutex objects if they want to acquire the resource.
- They allow multiple program threads to access a single shared resource but one at a time.
---
