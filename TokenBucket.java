import java.util.function.DoubleSupplier;

/** Token-bucket rate limiter. Not thread-safe; guard externally if shared. */
public final class TokenBucket {
    private final double rate, capacity;
    private double tokens, last;
    private final DoubleSupplier now;

    public TokenBucket(double ratePerSec, double capacity, DoubleSupplier now) {
        this.rate = ratePerSec;
        this.capacity = capacity;
        this.tokens = capacity;
        this.now = now;
        this.last = now.getAsDouble();
    }

    /** Refill by elapsed time, then take {@code cost} tokens if available. */
    public boolean allow(double cost) {
        double t = now.getAsDouble();
        tokens = Math.min(capacity, tokens + (t - last) * rate);
        last = t;
        if (tokens >= cost) {
            tokens -= cost;
            return true;
        }
        return false;
    }
}
