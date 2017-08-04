package org.yatech.common.args

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Yinon Avraham.
 */
class CollectionArgsSpec extends Specification {

    /* **************************************************************
     * require collection contains element
     * **************************************************************/

    @Unroll
    def 'successfully require collection contains element. collection=#collection, element=#element'() {
        when:
        def result = CollectionArgs.requireContains(collection, element, 'requirement failed')

        then:
        result == collection

        where:
        collection           | element
        [1, 2, 3]            | 1
        [1, 2, 3]            | 2
        [1, 2, 3].toSet()    | 3
        [1, 2, null].toSet() | null
    }

    @Unroll
    def 'fail require collection contains element. collection=#collection, element=#element'() {
        when:
        CollectionArgs.requireContains(collection, element, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        collection           | element
        [1, 2, 3]            | 4
        [1, 2, 3]            | null
        [1, 2, 3].toSet()    | 0
        [1, 2, null].toSet() | 5
    }

    /* **************************************************************
     * require collection excludes element
     * **************************************************************/

    @Unroll
    def 'successfully require collection excludes element. collection=#collection, element=#element'() {
        when:
        def result = CollectionArgs.requireExcludes(collection, element, 'requirement failed')

        then:
        result == collection

        where:
        collection        | element
        [1, 2, 3]         | 0
        [1, 2, null]      | 4
        [1, 2, 3].toSet() | 5
        [1, 2, 3].toSet() | null
    }

    @Unroll
    def 'fail require collection excludes element. collection=#collection, element=#element'() {
        when:
        CollectionArgs.requireExcludes(collection, element, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        collection        | element
        [1, 2, 3]         | 3
        [1, 2, null]      | null
        [1, 2, 3].toSet() | 1
    }

    /* **************************************************************
     * require map contains key
     * **************************************************************/

    @Unroll
    def 'successfully require map contains key. map=#map, key=#key'() {
        when:
        def result = CollectionArgs.requireContainsKey(map, key, 'requirement failed')

        then:
        result == map

        where:
        map                | key
        [1: 1, 2: 2, 3: 3] | 1
        [1: 1, 2: 2, 3: 3] | 2
        [a: 1, b: 2, c: 3] | 'c'
    }

    @Unroll
    def 'fail require map contains key. map=#map, key=#key'() {
        when:
        CollectionArgs.requireContainsKey(map, key, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        map                   | key
        [1: 1, 2: 2, 3: 3]    | 4
        [1: 1, 2: 2, 3: 3]    | null
        [a: 1, b: 2, c: 3]    | 'd'
        [a: 1, b: 2, c: null] | 5
    }

    /* **************************************************************
     * require collection excludes element
     * **************************************************************/

    @Unroll
    def 'successfully require map excludes key. map=#map, key=#key'() {
        when:
        def result = CollectionArgs.requireExcludesKey(map, key, 'requirement failed')

        then:
        result == map

        where:
        map                   | key
        [1: 1, 2: 2, 3: 3]    | 4
        [1: 1, 2: 2, 3: 3]    | null
        [a: 1, b: 2, c: null] | 'd'
    }

    @Unroll
    def 'fail require map excludes key. map=#map, key=#key'() {
        when:
        CollectionArgs.requireExcludesKey(map, key, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        map                | key
        [1: 1, 2: 2, 3: 3] | 1
        [a: 1, b: 2, c: 3] | 'b'
    }

    /* **************************************************************
     * require map contains value
     * **************************************************************/

    @Unroll
    def 'successfully require map contains value. map=#map, value=#value'() {
        when:
        def result = CollectionArgs.requireContainsValue(map, value, 'requirement failed')

        then:
        result == map

        where:
        map                      | value
        [1: 'a', 2: 'b', 3: 'c'] | 'a'
        [1: 'a', 2: 'b', 3: 'c'] | 'b'
        [a: 1, b: 2, c: 3]       | 3
        [a: 1, b: 2, c: null]    | null
    }

    @Unroll
    def 'fail require map contains value. map=#map, value=#value'() {
        when:
        CollectionArgs.requireContainsValue(map, value, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        map                      | value
        [1: 'a', 2: 'b', 3: 'c'] | 'd'
        [1: 'a', 2: 'b', 3: 'c'] | null
        [a: 1, b: 2, c: 3]       | 4
    }

    /* **************************************************************
     * require collection excludes element
     * **************************************************************/

    @Unroll
    def 'successfully require map excludes value. map=#map, value=#value'() {
        when:
        def result = CollectionArgs.requireExcludesValue(map, value, 'requirement failed')

        then:
        result == map

        where:
        map                      | value
        [1: 'a', 2: 'b', 3: 'c'] | null
        [a: 1, b: 2, c: 3]       | 4
        [a: 1, b: 2, c: 3]       | 'a'
    }

    @Unroll
    def 'fail require map excludes value. map=#map, value=#value'() {
        when:
        CollectionArgs.requireExcludesValue(map, value, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        map                       | value
        [1: 'a', 2: 'b', 3: null] | null
        [a: 1, b: 2, c: 3]        | 3
    }

    /* **************************************************************
     * require collection/map max size
     * **************************************************************/

    @Unroll
    def 'successfully require max size of a collection. collection=#collection, size=#size'() {
        when:
        def result = CollectionArgs.requireMaxSize(collection, size, 'requirement failed')

        then:
        result == collection

        where:
        collection        | size
        [1, 2, 3]         | 3
        [1, 2, 3].toSet() | 4
        []                | 0
    }

    @Unroll
    def 'fail require max size of a collection. collection=#collection, size=#size'() {
        when:
        CollectionArgs.requireMaxSize(collection, size, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        collection        | size
        [1, 2, 3]         | 2
        [1, 2, 3].toSet() | 1
    }

    @Unroll
    def 'successfully require max size of a map. map=#map, size=#size'() {
        when:
        def result = CollectionArgs.requireMaxSize(map, size, 'requirement failed')

        then:
        result == map

        where:
        map                | size
        [1: 1, 2: 2, 3: 3] | 3
        [1: 1, 2: 2, 3: 3] | 4
        [:]                | 0
    }

    @Unroll
    def 'fail require max size of a map. map=#map, size=#size'() {
        when:
        CollectionArgs.requireMaxSize(map, size, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        map                | size
        [1: 1, 2: 2, 3: 3] | 2
    }

    @Unroll
    def 'fail require max size of a null collection/map'() {
        when: 'list'
        CollectionArgs.requireMaxSize((List) null, 1, 'requirement failed')
        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'set'
        CollectionArgs.requireMaxSize((Set) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'collection'
        CollectionArgs.requireMaxSize((Collection) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'map'
        CollectionArgs.requireMaxSize((Map) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* **************************************************************
     * require empty collection/map
     * **************************************************************/

    @Unroll
    def 'successfully require empty collection'() {
        when:
        def result = CollectionArgs.requireEmpty(collection, 'requirement failed')

        then:
        result == collection

        where:
        collection | _
        []         | _
        [].toSet() | _
    }

    @Unroll
    def 'successfully require empty map'() {
        expect:
        CollectionArgs.requireEmpty([:], 'requirement failed') == [:]
    }

    @Unroll
    def 'fail require empty collection/map'() {
        when:
        CollectionArgs.requireEmpty(value, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value       | _
        [1]         | _
        [1].toSet() | _
        [1: 1]      | _
    }

    @Unroll
    def 'fail require empty a null collection/map'() {
        when: 'list'
        CollectionArgs.requireEmpty((List) null, 'requirement failed')
        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'set'
        CollectionArgs.requireEmpty((Set) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'collection'
        CollectionArgs.requireEmpty((Collection) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'map'
        CollectionArgs.requireEmpty((Map) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* **************************************************************
     * require collection/map min size
     * **************************************************************/

    @Unroll
    def 'successfully require min size of a collection. collection=#collection, size=#size'() {
        when:
        def result = CollectionArgs.requireMinSize(collection, size, 'requirement failed')

        then:
        result == collection

        where:
        collection        | size
        [1, 2, 3]         | 0
        [1, 2, 3].toSet() | 1
        []                | 0
    }

    @Unroll
    def 'fail require min size of a collection. collection=#collection, size=#size'() {
        when:
        CollectionArgs.requireMinSize(collection, size, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        collection        | size
        [1, 2, 3]         | 4
        [1, 2, 3].toSet() | 5
    }

    @Unroll
    def 'successfully require min size of a map. map=#map, size=#size'() {
        when:
        def result = CollectionArgs.requireMinSize(map, size, 'requirement failed')

        then:
        result == map

        where:
        map                | size
        [1: 1, 2: 2, 3: 3] | 1
        [1: 1, 2: 2, 3: 3] | 2
        [:]                | 0
    }

    @Unroll
    def 'fail require min size of a map. map=#map, size=#size'() {
        when:
        CollectionArgs.requireMinSize(map, size, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        map                | size
        [1: 1, 2: 2, 3: 3] | 4
    }

    @Unroll
    def 'fail require min size of a null collection/map'() {
        when: 'list'
        CollectionArgs.requireMinSize((List) null, 1, 'requirement failed')
        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'set'
        CollectionArgs.requireMinSize((Set) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'collection'
        CollectionArgs.requireMinSize((Collection) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'map'
        CollectionArgs.requireMinSize((Map) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* **************************************************************
     * require non-empty collection/map
     * **************************************************************/

    @Unroll
    def 'successfully require non-empty collection'() {
        when:
        def result = CollectionArgs.requireNonEmpty(collection, 'requirement failed')

        then:
        result == collection

        where:
        collection | _
        [1]         | _
        [1,2,3].toSet() | _
    }

    @Unroll
    def 'successfully require non-empty map'() {
        expect:
        CollectionArgs.requireNonEmpty([1:1], 'requirement failed') == [1:1]
    }

    @Unroll
    def 'fail require non-empty collection/map'() {
        when:
        CollectionArgs.requireNonEmpty(value, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value       | _
        []         | _
        [].toSet() | _
        [:]      | _
    }

    @Unroll
    def 'fail require non-empty a null collection/map'() {
        when: 'list'
        CollectionArgs.requireNonEmpty((List) null, 'requirement failed')
        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'set'
        CollectionArgs.requireNonEmpty((Set) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'collection'
        CollectionArgs.requireNonEmpty((Collection) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'map'
        CollectionArgs.requireNonEmpty((Map) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }
}
