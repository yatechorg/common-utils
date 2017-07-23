package org.yatech.common.args;

import javax.annotation.Nonnull;
import java.util.regex.Pattern;

import static org.yatech.common.args.Args.requireSatisfies;

/**
 * @author Yinon Avraham.
 */
public abstract class StringArgs {

    private StringArgs() {
        //utility
    }

    public static final Pattern WHITESPACES_ONLY = Pattern.compile("\\s+");

    /**
     * Require that the given value is non-blank (not whitespaces only)
     * @param value the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    @Nonnull
    public static String requireNonBlank(String value, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v.length() > 0 && !WHITESPACES_ONLY.matcher(v).matches(), message);
    }

    /**
     * Require that the given value is not empty
     * @param value the value to check
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    @Nonnull
    public static String requireNonEmpty(String value, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && v.length() > 0, message);
    }

    /**
     * Require that the given value matches the given pattern
     * @param value the value to check
     * @param pattern the pattern to match
     * @param message the error message to use
     * @return the value if satisfies the requirement
     * @throws IllegalArgumentException if the value does not satisfy the requirement
     */
    @Nonnull
    public static String requireMatches(String value, @Nonnull Pattern pattern, @Nonnull String message) {
        return requireSatisfies(value, v -> v != null && pattern.matcher(v).matches(), message);
    }

}
