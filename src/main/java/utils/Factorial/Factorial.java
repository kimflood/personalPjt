package Factorial;

import java.math.BigInteger;


public class Factorial {

}

class TailCalls {
    public static <T> TailCall<T> call(final TailCall<T> nextCall) {
        return nextCall;
    }

    public static <T> TailCall<T> done(final T value) {
        return new TailCall<T>() {
            @Override public boolean isComplete() { return true; }
            @Override public T result() { return value; }
            @Override public TailCall<T> apply() {
                throw new Error("not implemented");
            }
        };
    }
}

class FactorialToBigInteger {
    final static BigInteger ONE = BigInteger.ONE;
    final static BigInteger TEN = new BigInteger("10");
    final static BigInteger TWENTY_K = new BigInteger("80000");

    private static BigInteger decrement(final BigInteger number){
        return number.subtract(ONE);
    }

    private static BigInteger multiply(final BigInteger first, final BigInteger second){
        return first.multiply(second);
    }

    private static TailCall<BigInteger> factorialTailRec(final BigInteger factorial, final BigInteger number) {
        if (number.equals(ONE)) {
            return TailCalls.done(factorial);
        }
        return TailCalls.call(() -> factorialTailRec(multiply(factorial, number), decrement(number)));
    }

    public static BigInteger factorial(final BigInteger number){
        return factorialTailRec(ONE, number).invoke();
    }
}
