package org.yatech.common.args;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Yinon Avraham.
 */
public abstract class Args {

    private Args() {
        //utility
    }

    /**
     * Require that the given value is not null and return it
     * @param value the value to check
     * @param message the error message to use
     * @param <V> the value type
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    @Nonnull
    public static <V> V requireNonNull(V value, @Nonnull String message) {
        return requireSatisfies(value, Objects::nonNull, message);
    }

    /**
     * Require that the given value satisfies the given predicate
     * @param <V> the value type
     * @param value the value to check
     * @param predicate the predicate to satisfy
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    public static <V> V requireSatisfies(@Nullable V value, @Nonnull Predicate<V> predicate, @Nonnull String message) {
        if (!predicate.test(value)) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}
