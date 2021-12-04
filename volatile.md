## Volatile Keyword
- Every read of a volatile variable will be read from the RAM and not from the cache.
- We use `volatile` is we don't want a variable to be cached, and we always want to read it from RAM.
- Usually variables are cached for performances reasons
- Caches are faster, do not use the `volatile` keyword if not necessary(it prevents instruction reordering which is a performance boost technique)
---