package org.yatech.common.args;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;

import static org.yatech.common.args.Args.requireSatisfies;

/**
 * A utility class for common methods on arguments of type {@link java.util.Collection}
 *
 * @author Yinon Avraham.
 */
public abstract class CollectionArgs {

    private CollectionArgs() {
        //utility
    }

    /**
     * Require that a given collection contain a specific element
     * @param collection the collection to check
     * @param element the required element
     * @param message the error message
     * @param <C> the collection type
     * @param <E> the element type
     * @return the collection if the requirement is satisfied
     */
    @Nonnull
    public static <C extends Collection<E>, E> C requireContains(C collection, E element, @Nonnull String message) {
        return requireSatisfies(collection, c -> c != null && c.contains(element), message);
    }

    /**
     * Require that a given map contain a specific key
     * @param map the map to check
     * @param key the required key
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireContainsKey(M map, K key, @Nonnull String message) {
        return requireSatisfies(map, m -> m != null && m.containsKey(key), message);
    }

    /**
     * Require that a given map contain a specific value
     * @param map the map to check
     * @param value the required value
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireContainsValue(M map, V value, @Nonnull String message) {
        return requireSatisfies(map, m -> m != null && m.containsValue(value), message);
    }

    /**
     * Require that a given collection does not contain a specific element
     * @param collection the collection to check
     * @param element the element to exclude
     * @param message the error message
     * @param <C> the collection type
     * @param <E> the element type
     * @return the collection if the requirement is satisfied
     */
    @Nonnull
    public static <C extends Collection<E>, E> C requireExcludes(C collection, E element, @Nonnull String message) {
        return requireSatisfies(collection, c -> !c.contains(element), message);
    }

    /**
     * Require that a given map does not contain a specific key
     * @param map the map to check
     * @param key the key to exclude
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireExcludesKey(M map, K key, @Nonnull String message) {
        return requireSatisfies(map, m -> !m.containsKey(key), message);
    }

    /**
     * Require that a given map does not contain a specific value
     * @param map the map to check
     * @param value the value to exclude
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireExcludesValue(M map, V value, @Nonnull String message) {
        return requireSatisfies(map, m -> !m.containsValue(value), message);
    }

    /**
     * Require that a given collection does not exceed a max size
     * @param collection the collection to check
     * @param size the maximum size
     * @param message the error message
     * @param <C> the collection type
     * @param <E> the element type
     * @return the collection if the requirement is satisfied
     */
    @Nonnull
    public static <C extends Collection<E>, E> C requireMaxSize(C collection, int size, @Nonnull String message) {
        return requireSatisfies(collection, c -> c != null && c.size() <= size, message);
    }

    /**
     * Require that a given map does not exceed a max size
     * @param map the map to check
     * @param size the maximum size
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireMaxSize(M map, int size, @Nonnull String message) {
        return requireSatisfies(map, m -> m != null && m.size() <= size, message);
    }

    /**
     * Require that a given collection is empty
     * @param collection the collection to check
     * @param message the error message
     * @param <C> the collection type
     * @param <E> the element type
     * @return the collection if the requirement is satisfied
     */
    @Nonnull
    public static <C extends Collection<E>, E> C requireEmpty(C collection, @Nonnull String message) {
        return requireMaxSize(collection, 0, message);
    }

    /**
     * Require that a given map is empty
     * @param map the map to check
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireEmpty(M map, @Nonnull String message) {
        return requireMaxSize(map, 0, message);
    }

    /**
     * Require that a given collection has a minimum size
     * @param collection the collection to check
     * @param size the minimum size
     * @param message the error message
     * @param <C> the collection type
     * @param <E> the element type
     * @return the collection if the requirement is satisfied
     */
    @Nonnull
    public static <C extends Collection<E>, E> C requireMinSize(C collection, int size, @Nonnull String message) {
        return requireSatisfies(collection, c -> c != null && c.size() >= size, message);
    }

    /**
     * Require that a given map has a minimum size
     * @param map the map to check
     * @param size the minimum size
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireMinSize(M map, int size, @Nonnull String message) {
        return requireSatisfies(map, m -> m != null && m.size() >= size, message);
    }

    /**
     * Require that a given collection is not empty
     * @param collection the collection to check
     * @param message the error message
     * @param <C> the collection type
     * @param <E> the element type
     * @return the collection if the requirement is satisfied
     */
    @Nonnull
    public static <C extends Collection<E>, E> C requireNonEmpty(C collection, @Nonnull String message) {
        return requireMinSize(collection, 1, message);
    }

    /**
     * Require that a given map is not empty
     * @param map the map to check
     * @param message the error message
     * @param <M> the map type
     * @param <K> the key type
     * @param <V> the value type
     * @return the map if the requirement is satisfied
     */
    @Nonnull
    public static <M extends Map<K, V>, K, V> M requireNonEmpty(M map, @Nonnull String message) {
        return requireMinSize(map, 1, message);
    }
}
