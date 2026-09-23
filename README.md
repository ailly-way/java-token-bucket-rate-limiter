# In-memory token-bucket rate limiter

```
TokenBucket.java
```

Financial systems require strict request throttling. This prevents abuse and maintains SLA compliance. This implementation provides an in-memory token bucket. It requires no Redis. There are no external dependencies. It uses only the Java standard library.

The real gotcha in rate limiting is non-deterministic time. Hardcoding system time makes unit tests flaky. It complicates compliance audit reproduction. This design injects a time source. You control the clock.

Run the test suite next to the implementation for concrete examples.