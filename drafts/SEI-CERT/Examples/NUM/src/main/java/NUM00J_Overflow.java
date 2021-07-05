import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class NUM00J_Overflow {
    public static int multAccumBad(int oldAcc, int newVal, int scale) {
        // May result in overflow
        return oldAcc + (newVal * scale);
    }

    public static int multAccumGood(int oldAcc, int newVal, int scale) {
        return safeAdd(oldAcc, safeMultiply(newVal, scale));
    }

    public static int multAccumGoodJava8(int oldAcc, int newVal, int scale) {
        return Math.addExact(oldAcc, Math.multiplyExact(newVal, scale));
    }

    public static long intRangeCheck(long value) {
        if ((value < Integer.MIN_VALUE) || (value > Integer.MAX_VALUE)) {
            throw new ArithmeticException("Integer overflow");
        }
        return value;
    }

    public static int multAccumGoodCast(int oldAcc, int newVal, int scale) {
        final long res = intRangeCheck(
                ((long) oldAcc) + intRangeCheck((long) newVal * (long) scale)
        );
        return (int) res; // Safe downcast
    }

    private static final BigInteger bigMaxInt =
            BigInteger.valueOf(Integer.MAX_VALUE);
    private static final BigInteger bigMinInt =
            BigInteger.valueOf(Integer.MIN_VALUE);

    public static BigInteger intRangeCheck(BigInteger val) {
        if (val.compareTo(bigMaxInt) == 1 ||
                val.compareTo(bigMinInt) == -1) {
            throw new ArithmeticException("Integer overflow");
        }
        return val;
    }

    public static int multAccumGoodBigInteger(int oldAcc, int newVal, int scale) {
        BigInteger product =
                BigInteger.valueOf(newVal).multiply(BigInteger.valueOf(scale));
        BigInteger res =
                intRangeCheck(BigInteger.valueOf(oldAcc).add(product));
        return res.intValue(); // Safe conversion
    }

    private final AtomicInteger itemsInInventory = new AtomicInteger(100);

    //...
    public final void nextItemBad() {
        itemsInInventory.getAndIncrement();
    }

    public final void nextItemGood() {
        while (true) {
            int old = itemsInInventory.get();
            if (old == Integer.MAX_VALUE) {
                throw new ArithmeticException("Integer overflow");
            }
            int next = old + 1; // Increment
            if (itemsInInventory.compareAndSet(old, next)) {
                break;
            }
        } // End while
    } // End nextItem()

    static final int safeAdd(int left, int right) {
        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left + right;
    }

    static final int safeSubtract(int left, int right) {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left - right;
    }

    static final int safeMultiply(int left, int right) {
        if (right > 0 ? left > Integer.MAX_VALUE/right
                || left < Integer.MIN_VALUE/right
                : (right < -1 ? left > Integer.MIN_VALUE/right
                || left < Integer.MAX_VALUE/right
                : right == -1
                && left == Integer.MIN_VALUE) ) {
            throw new ArithmeticException("Integer overflow");
        }
        return left * right;
    }

    static final int safeDivide(int left, int right) {
        if ((left == Integer.MIN_VALUE) && (right == -1)) {
            throw new ArithmeticException("Integer overflow");
        }
        return left / right;
    }

    static final int safeNegate(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer overflow");
        }
        return -a;
    }
    static final int safeAbs(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer overflow");
        }
        return Math.abs(a);
    }
}
