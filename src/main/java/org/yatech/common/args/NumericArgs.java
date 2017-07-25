package org.yatech.common.args;

import javax.annotation.Nonnull;

import static org.yatech.common.args.Args.requireSatisfies;

/**
 * @author Yinon Avraham.
 */
public abstract class NumericArgs {

    private NumericArgs() {
        //utility
    }

    /* *********************************************************************************
     * Long                                                                            *
     ***********************************************************************************/

    /**
     * Require that the given value is positive (<tt>value &gt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requirePositive(Long value, String message) {
        return requireGreaterThan(value, 0, message);
    }

    /**
     * Require that the given value is non-negative (<tt>value &gt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireNonNegative(Long value, String message) {
        return requireGreaterThanEquals(value, 0, message);
    }

    /**
     * Require that the given value is greater than another value (<tt>value &gt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireGreaterThan(Long value, long other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v > other, message);
    }

    /**
     * Require that the given value is greater than or equals to another value (<tt>value &gt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireGreaterThanEquals(Long value, long other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v >= other, message);
    }

    /**
     * Require that the given value is negative (<tt>value &lt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireNegative(Long value, String message) {
        return requireLessThan(value, 0, message);
    }

    /**
     * Require that the given value is non-positive (<tt>value &lt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireNonPositive(Long value, String message) {
        return requireLessThanEquals(value, 0, message);
    }

    /**
     * Require that the given value is less than another value (<tt>value &lt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireLessThan(Long value, long other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v < other, message);
    }

    /**
     * Require that the given value is less than or equals to another value (<tt>value &lt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireLessThanEquals(Long value, long other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v <= other, message);
    }

    /**
     * Require that the given value is not zero (<tt>value != 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireNonZero(Long value, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v != 0, message);
    }

    /**
     * Require that the given value is in a given range (inclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (inclusive)
     * @param to            the upper end of the range (inclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireInRangeInclusive(Long value, long from, long to, @Nonnull String message) {
        return requireInRange(value, from, true, to, true, message);
    }

    /**
     * Require that the given value is in a given range (exclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (exclusive)
     * @param to            the upper end of the range (exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireInRangeExclusive(Long value, long from, long to, @Nonnull String message) {
        return requireInRange(value, from, false, to, false, message);
    }

    /**
     * Require that the given value is in a given range
     *
     * @param value         the value to check
     * @param from          the lower end of the range
     * @param fromInclusive whether the lower end is inclusive (or exclusive)
     * @param to            the upper end of the range
     * @param toInclusive   whether the upper end is inclusive (or exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static long requireInRange(Long value, long from, boolean fromInclusive, long to, boolean toInclusive,
                                      @Nonnull String message) {
        return requireSatisfies(value, v -> v != null &&
                        (fromInclusive ? v >= from : v > from) &&
                        (toInclusive ? value <= to : value < to),
                message);
    }

    /* *********************************************************************************
     * Integer                                                                         *
     ***********************************************************************************/

    /**
     * Require that the given value is positive (<tt>value &gt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requirePositive(Integer value, String message) {
        return requireGreaterThan(value, 0, message);
    }

    /**
     * Require that the given value is non-negative (<tt>value &gt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireNonNegative(Integer value, String message) {
        return requireGreaterThanEquals(value, 0, message);
    }

    /**
     * Require that the given value is greater than another value (<tt>value &gt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireGreaterThan(Integer value, int other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v > other, message);
    }

    /**
     * Require that the given value is greater than or equals to another value (<tt>value &gt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireGreaterThanEquals(Integer value, int other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v >= other, message);
    }

    /**
     * Require that the given value is negative (<tt>value &lt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireNegative(Integer value, String message) {
        return requireLessThan(value, 0, message);
    }

    /**
     * Require that the given value is non-positive (<tt>value &lt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireNonPositive(Integer value, String message) {
        return requireLessThanEquals(value, 0, message);
    }

    /**
     * Require that the given value is less than another value (<tt>value &lt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireLessThan(Integer value, int other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v < other, message);
    }

    /**
     * Require that the given value is less than or equals to another value (<tt>value &lt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireLessThanEquals(Integer value, int other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v <= other, message);
    }

    /**
     * Require that the given value is not zero (<tt>value != 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireNonZero(Integer value, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v != 0, message);
    }

    /**
     * Require that the given value is in a given range (inclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (inclusive)
     * @param to            the upper end of the range (inclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireInRangeInclusive(Integer value, int from, int to, @Nonnull String message) {
        return requireInRange(value, from, true, to, true, message);
    }

    /**
     * Require that the given value is in a given range (exclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (exclusive)
     * @param to            the upper end of the range (exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireInRangeExclusive(Integer value, int from, int to, @Nonnull String message) {
        return requireInRange(value, from, false, to, false, message);
    }

    /**
     * Require that the given value is in a given range
     *
     * @param value         the value to check
     * @param from          the lower end of the range
     * @param fromInclusive whether the lower end is inclusive (or exclusive)
     * @param to            the upper end of the range
     * @param toInclusive   whether the upper end is inclusive (or exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static int requireInRange(Integer value, int from, boolean fromInclusive, int to, boolean toInclusive,
                                      @Nonnull String message) {
        return requireSatisfies(value, v -> v != null &&
                        (fromInclusive ? v >= from : v > from) &&
                        (toInclusive ? value <= to : value < to),
                message);
    }

    /* *********************************************************************************
     * Double                                                                          *
     ***********************************************************************************/

    /**
     * Require that the given value is positive (<tt>value &gt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requirePositive(Double value, String message) {
        return requireGreaterThan(value, 0.0d, message);
    }

    /**
     * Require that the given value is non-negative (<tt>value &gt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireNonNegative(Double value, String message) {
        return requireGreaterThanEquals(value, 0.0d, message);
    }

    /**
     * Require that the given value is greater than another value (<tt>value &gt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireGreaterThan(Double value, double other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v > other, message);
    }

    /**
     * Require that the given value is greater than or equals to another value (<tt>value &gt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireGreaterThanEquals(Double value, double other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v >= other, message);
    }

    /**
     * Require that the given value is negative (<tt>value &lt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireNegative(Double value, String message) {
        return requireLessThan(value, 0.0d, message);
    }

    /**
     * Require that the given value is non-positive (<tt>value &lt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireNonPositive(Double value, String message) {
        return requireLessThanEquals(value, 0.0d, message);
    }

    /**
     * Require that the given value is less than another value (<tt>value &lt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireLessThan(Double value, double other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v < other, message);
    }

    /**
     * Require that the given value is less than or equals to another value (<tt>value &lt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireLessThanEquals(Double value, double other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v <= other, message);
    }

    /**
     * Require that the given value is not zero (<tt>value != 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireNonZero(Double value, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v != 0.0d, message);
    }

    /**
     * Require that the given value is in a given range (inclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (inclusive)
     * @param to            the upper end of the range (inclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireInRangeInclusive(Double value, double from, double to, @Nonnull String message) {
        return requireInRange(value, from, true, to, true, message);
    }

    /**
     * Require that the given value is in a given range (exclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (exclusive)
     * @param to            the upper end of the range (exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireInRangeExclusive(Double value, double from, double to, @Nonnull String message) {
        return requireInRange(value, from, false, to, false, message);
    }

    /**
     * Require that the given value is in a given range
     *
     * @param value         the value to check
     * @param from          the lower end of the range
     * @param fromInclusive whether the lower end is inclusive (or exclusive)
     * @param to            the upper end of the range
     * @param toInclusive   whether the upper end is inclusive (or exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static double requireInRange(Double value, double from, boolean fromInclusive, double to, boolean toInclusive,
                                      @Nonnull String message) {
        return requireSatisfies(value, v -> v != null &&
                        (fromInclusive ? v >= from : v > from) &&
                        (toInclusive ? value <= to : value < to),
                message);
    }

    /* *********************************************************************************
     * Float                                                                           *
     ***********************************************************************************/

    /**
     * Require that the given value is positive (<tt>value &gt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requirePositive(Float value, String message) {
        return requireGreaterThan(value, 0.0f, message);
    }

    /**
     * Require that the given value is non-negative (<tt>value &gt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireNonNegative(Float value, String message) {
        return requireGreaterThanEquals(value, 0.0f, message);
    }

    /**
     * Require that the given value is greater than another value (<tt>value &gt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireGreaterThan(Float value, float other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v > other, message);
    }

    /**
     * Require that the given value is greater than or equals to another value (<tt>value &gt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireGreaterThanEquals(Float value, float other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v >= other, message);
    }

    /**
     * Require that the given value is negative (<tt>value &lt; 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireNegative(Float value, String message) {
        return requireLessThan(value, 0.0f, message);
    }

    /**
     * Require that the given value is non-positive (<tt>value &lt;= 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireNonPositive(Float value, String message) {
        return requireLessThanEquals(value, 0.0f, message);
    }

    /**
     * Require that the given value is less than another value (<tt>value &lt; other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireLessThan(Float value, float other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v < other, message);
    }

    /**
     * Require that the given value is less than or equals to another value (<tt>value &lt;= other</tt>)
     *
     * @param value   the value to check
     * @param other   the other value to compare with
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireLessThanEquals(Float value, float other, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v <= other, message);
    }

    /**
     * Require that the given value is not zero (<tt>value != 0</tt>)
     *
     * @param value   the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireNonZero(Float value, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v != 0.0f, message);
    }

    /**
     * Require that the given value is in a given range (inclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (inclusive)
     * @param to            the upper end of the range (inclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireInRangeInclusive(Float value, float from, float to, @Nonnull String message) {
        return requireInRange(value, from, true, to, true, message);
    }

    /**
     * Require that the given value is in a given range (exclusive)
     *
     * @param value         the value to check
     * @param from          the lower end of the range (exclusive)
     * @param to            the upper end of the range (exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireInRangeExclusive(Float value, float from, float to, @Nonnull String message) {
        return requireInRange(value, from, false, to, false, message);
    }

    /**
     * Require that the given value is in a given range
     *
     * @param value         the value to check
     * @param from          the lower end of the range
     * @param fromInclusive whether the lower end is inclusive (or exclusive)
     * @param to            the upper end of the range
     * @param toInclusive   whether the upper end is inclusive (or exclusive)
     * @param message       the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static float requireInRange(Float value, float from, boolean fromInclusive, float to, boolean toInclusive,
                                      @Nonnull String message) {
        return requireSatisfies(value, v -> v != null &&
                        (fromInclusive ? v >= from : v > from) &&
                        (toInclusive ? value <= to : value < to),
                message);
    }

}
