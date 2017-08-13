package org.yatech.common.collection.sqlike;

public interface Predicate<E> {

    boolean satisfiedBy(E element);

}
