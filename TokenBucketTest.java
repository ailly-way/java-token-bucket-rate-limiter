/** Run: javac *.java && java TokenBucketTest */
public class TokenBucketTest {
    static double clock = 0.0;
    public static void main(String[] args) {
        TokenBucket b = new TokenBucket(1.0, 2.0, () -> clock);
        if (!b.allow(2.0)) throw new AssertionError("initial capacity");
        if (b.allow(1.0)) throw new AssertionError("should be empty");
        clock = 1.0;
        if (!b.allow(1.0)) throw new AssertionError("should refill");
        System.out.println("ok");
    }
}
