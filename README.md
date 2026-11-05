# In-memory token-bucket rate limiter

Small token bucket. Inject clock for deterministic tests. No Redis, no dependencies.

```
TokenBucket.java
```
Standard library only. No service to install or network call to trust.

The real gotcha: limits are per JVM. Horizontal scaling multiplies allowed throughput. For compliance, treat each node as its own ledger.

Run the test next to the implementation. It shows refill behavior concretely.