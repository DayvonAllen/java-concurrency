## Callable Interface
- We use `Callable's` `call()` method when we want to return a given value from the given thread
- We use `Runnable's` `run()` method when we want to execute a `run-and-forget` action.
  - When we don't expect a return value.
- Callable interface will not return the value, therefore we need the `Future<T>` object
  - The calling thread will be blocked until the `call()` method is executed and `Future<T>` returns with the results.
- The executor framework uses `execute()` for runnable objects 
- The executor framework uses `submit()` for callable objects 
  - It can handle a `Future<T>` return value, and we can get the `T` value with `get()` on the future object.
---