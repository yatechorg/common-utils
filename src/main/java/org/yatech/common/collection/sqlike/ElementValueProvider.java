package org.yatech.common.collection.sqlike;

public interface ElementValueProvider<E, V> {

    V getValue(E element);

}
