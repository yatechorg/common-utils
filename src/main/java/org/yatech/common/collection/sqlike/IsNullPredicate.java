package org.yatech.common.collection.sqlike;

final class IsNullPredicate<E> implements Predicate<E> {

    public IsNullPredicate() {
    }

    @Override
    public boolean satisfiedBy(E element) {
        return element == null;
    }

}
