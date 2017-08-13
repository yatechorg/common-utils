package org.yatech.common.collection.sqlike;


public interface QueryableCollection<E> extends
        SqlLikeCollection<E>,
        WhereSupport<E, QueryableCollection<E>>,
        OrderBySupport<E, QueryableList<E>> {

}
