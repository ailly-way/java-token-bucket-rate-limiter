# In-memory token-bucket rate limiter

```
TokenBucket.java
```

This utility enforces API throughput limits using standard Java concurrency primitives. Local state avoids network partition risks during core transaction processing.

Time-dependent logic requires strict clock control. The main gotcha is thread contention when advancing the mock clock across concurrent bucket checks. Inject a monotonic clock interface to keep audit tests deterministic.