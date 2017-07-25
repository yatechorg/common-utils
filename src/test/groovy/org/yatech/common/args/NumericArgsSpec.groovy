package org.yatech.common.args

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Yinon Avraham.
 */
class NumericArgsSpec extends Specification {

    /* *************************************************************************
     * require positive
     * *************************************************************************/

    @Unroll
    def 'successfully require positive: #value'() {
        when:
        def result = NumericArgs.requirePositive(value, 'positive value required')

        then:
        result == value

        where:
        value | _
        1     | _
        1L    | _
        0.1f  | _
        0.1d  | _
    }

    @Unroll
    def 'fail to require positive: #value'() {
        when:
        NumericArgs.requirePositive(value, 'positive value required')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'positive value required'

        where:
        value | _
        0     | _
        0L    | _
        0.0f  | _
        0.0d  | _
        -1    | _
        -1L   | _
        -0.1f | _
        -0.1d | _
    }

    def 'fail to require positive: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requirePositive((Integer) null, 'positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'positive value required'

        when: 'long'
        NumericArgs.requirePositive((Long) null, 'positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'positive value required'

        when: 'float'
        NumericArgs.requirePositive((Float) null, 'positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'positive value required'

        when: 'double'
        NumericArgs.requirePositive((Double) null, 'positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'positive value required'
    }

    /* *************************************************************************
     * require non-negative
     * *************************************************************************/

    @Unroll
    def 'successfully require non-negative: #value'() {
        when:
        def result = NumericArgs.requireNonNegative(value, 'non-negative value required')

        then:
        result == value

        where:
        value | _
        0     | _
        0L    | _
        0.0f  | _
        0.0d  | _
        1     | _
        1L    | _
        0.1f  | _
        0.1d  | _
    }

    @Unroll
    def 'fail to require non-negative: #value'() {
        when:
        NumericArgs.requireNonNegative(value, 'non-negative value required')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'non-negative value required'

        where:
        value | _
        -1    | _
        -1L   | _
        -0.1f | _
        -0.1d | _
    }

    def 'fail to require non-negative: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireNonNegative((Integer) null, 'non-negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-negative value required'

        when: 'long'
        NumericArgs.requireNonNegative((Long) null, 'non-negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-negative value required'

        when: 'float'
        NumericArgs.requireNonNegative((Float) null, 'non-negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-negative value required'

        when: 'double'
        NumericArgs.requireNonNegative((Double) null, 'non-negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-negative value required'
    }

    /* *************************************************************************
     * require negative
     * *************************************************************************/

    @Unroll
    def 'successfully require negative: #value'() {
        when:
        def result = NumericArgs.requireNegative(value, 'negative value required')

        then:
        result == value

        where:
        value | _
        -1    | _
        -1L   | _
        -0.1f | _
        -0.1d | _
    }

    @Unroll
    def 'fail to require negative: #value'() {
        when:
        NumericArgs.requireNegative(value, 'negative value required')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'negative value required'

        where:
        value | _
        0     | _
        0L    | _
        0.0f  | _
        0.0d  | _
        1     | _
        1L    | _
        0.1f  | _
        0.1d  | _
    }

    def 'fail to require negative: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireNegative((Integer) null, 'negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'negative value required'

        when: 'long'
        NumericArgs.requireNegative((Long) null, 'negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'negative value required'

        when: 'float'
        NumericArgs.requireNegative((Float) null, 'negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'negative value required'

        when: 'double'
        NumericArgs.requireNegative((Double) null, 'negative value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'negative value required'
    }

    /* *************************************************************************
     * require non-positive
     * *************************************************************************/

    @Unroll
    def 'successfully require non-positive: #value'() {
        when:
        def result = NumericArgs.requireNonPositive(value, 'non-positive value required')

        then:
        result == value

        where:
        value | _
        0     | _
        0L    | _
        0.0f  | _
        0.0d  | _
        -1    | _
        -1L   | _
        -0.1f | _
        -0.1d | _
    }

    @Unroll
    def 'fail to require non-positive: #value'() {
        when:
        NumericArgs.requireNonPositive(value, 'non-positive value required')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'non-positive value required'

        where:
        value | _
        1     | _
        1L    | _
        0.1f  | _
        0.1d  | _
    }

    def 'fail to require non-positive: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireNonPositive((Integer) null, 'non-positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-positive value required'

        when: 'long'
        NumericArgs.requireNonPositive((Long) null, 'non-positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-positive value required'

        when: 'float'
        NumericArgs.requireNonPositive((Float) null, 'non-positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-positive value required'

        when: 'double'
        NumericArgs.requireNonPositive((Double) null, 'non-positive value required')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'non-positive value required'
    }

    /* *************************************************************************
     * require greater than
     * *************************************************************************/

    @Unroll
    def 'successfully require greater than: #value'() {
        when:
        def result = NumericArgs.requireGreaterThan(value, other, 'requirement failed')

        then:
        result == value

        where:
        value | other
        2     | 0
        2L    | 0L
        0.5f  | 0.1f
        1.2d  | 0.1d
        0     | -1
        0L    | -1L
        0.0f  | -0.1f
        0.0d  | -0.1d
        -1    | -2
        -1L   | -2L
        -0.1f | -1.2f
        -0.1d | -2.3d
    }

    @Unroll
    def 'fail to require greater than: #value'() {
        when:
        NumericArgs.requireGreaterThan(value, other, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | other
        1     | 2
        1L    | 2L
        0.1f  | 0.2f
        0.1d  | 2.3d
        -1    | 2
        -1L   | 2L
        -0.1f | 0.2f
        -0.1d | 2.3d
        1     | 1
        1L    | 1L
        0.1f  | 0.1f
        0.1d  | 0.1d
    }

    def 'fail to require greater than: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireGreaterThan((Integer) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireGreaterThan((Long) null, 1L, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireGreaterThan((Float) null, 0.1f, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireGreaterThan((Double) null, 2.3d, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* *************************************************************************
     * require greater than or equals to
     * *************************************************************************/

    @Unroll
    def 'successfully require greater than or equals to: #value'() {
        when:
        def result = NumericArgs.requireGreaterThanEquals(value, other, 'requirement failed')

        then:
        result == value

        where:
        value | other
        2     | 0
        2L    | 0L
        0.5f  | 0.1f
        1.2d  | 0.1d
        0     | -1
        0L    | -1L
        0.0f  | -0.1f
        0.0d  | -0.1d
        -1    | -2
        -1L   | -2L
        -0.1f | -1.2f
        -0.1d | -2.3d
        2     | 2
        2L    | 2L
        0.5f  | 0.5f
        1.2d  | 1.2d
    }

    @Unroll
    def 'fail to require greater than or equals to: #value'() {
        when:
        NumericArgs.requireGreaterThanEquals(value, other, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | other
        1     | 2
        1L    | 2L
        0.1f  | 0.2f
        0.1d  | 2.3d
        -1    | 2
        -1L   | 2L
        -0.1f | 0.2f
        -0.1d | 2.3d
    }

    def 'fail to require greater than or equals to: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireGreaterThanEquals((Integer) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireGreaterThanEquals((Long) null, 1L, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireGreaterThanEquals((Float) null, 0.1f, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireGreaterThanEquals((Double) null, 2.3d, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* *************************************************************************
     * require less than
     * *************************************************************************/

    @Unroll
    def 'successfully require less than: #value'() {
        when:
        def result = NumericArgs.requireLessThan(value, other, 'requirement failed')

        then:
        result == value

        where:
        value | other
        0     | 2
        0L    | 2L
        0.1f  | 0.5f
        0.1d  | 1.2d
        -1    | 0
        -1L   | 0L
        -0.1f | 0.0f
        -0.1d | 0.0d
        -2    | -1
        -2L   | -1L
        -1.2f | -0.1f
        -2.3d | -0.1d
    }

    @Unroll
    def 'fail to require less than: #value'() {
        when:
        NumericArgs.requireLessThan(value, other, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | other
        2     | 1
        2L    | 1L
        0.2f  | 0.1f
        2.3d  | 0.1d
        2     | -1
        2L    | -1L
        0.2f  | -0.1f
        2.3d  | -0.1d
        1     | 1
        1L    | 1L
        0.1f  | 0.1f
        0.1d  | 0.1d
    }

    def 'fail to require less than: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireLessThan((Integer) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireLessThan((Long) null, 1L, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireLessThan((Float) null, 0.1f, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireLessThan((Double) null, 2.3d, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* *************************************************************************
     * require less than or equals to
     * *************************************************************************/

    @Unroll
    def 'successfully require less than or equals to: #value'() {
        when:
        def result = NumericArgs.requireLessThanEquals(value, other, 'requirement failed')

        then:
        result == value

        where:
        value | other
        0     | 2
        0L    | 2L
        0.1f  | 0.5f
        0.1d  | 1.2d
        -1    | 0
        -1L   | 0L
        -0.1f | 0.0f
        -0.1d | 0.0d
        -2    | -1
        -2L   | -1L
        -1.2f | -0.1f
        -2.3d | -0.1d
        2     | 2
        2L    | 2L
        0.5f  | 0.5f
        1.2d  | 1.2d
    }

    @Unroll
    def 'fail to require less than or equals to: #value'() {
        when:
        NumericArgs.requireLessThanEquals(value, other, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | other
        2     | 1
        2L    | 1L
        0.2f  | 0.1f
        2.3d  | 0.1d
        2     | -1
        2L    | -1L
        0.2f  | -0.1f
        2.3d  | -0.1d
    }

    def 'fail to require less than or equals to: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireLessThanEquals((Integer) null, 1, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireLessThanEquals((Long) null, 1L, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireLessThanEquals((Float) null, 0.1f, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireLessThanEquals((Double) null, 2.3d, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* *************************************************************************
     * require non-zero
     * *************************************************************************/

    @Unroll
    def 'successfully require non-zero: #value'() {
        when:
        def result = NumericArgs.requireNonZero(value, 'requirement failed')

        then:
        result == value

        where:
        value | _
        1     | _
        1L    | _
        0.1f  | _
        0.2d  | _
        -1    | _
        -1L   | _
        -0.1f | _
        -0.2d | _
    }

    @Unroll
    def 'fail to require non-zero: #value'() {
        when:
        NumericArgs.requireNonZero(value, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | other
        0     | _
        0L    | _
        0.0f  | _
        0.0d  | _
    }

    def 'fail to require non-zero: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireNonZero((Integer) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireNonZero((Long) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireNonZero((Float) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireNonZero((Double) null, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* *************************************************************************
     * require in range inclusive
     * *************************************************************************/

    @Unroll
    def 'successfully require in-range inclusive: #value'() {
        when:
        def result = NumericArgs.requireInRangeInclusive(value, from, to, 'requirement failed')

        then:
        result == value

        where:
        value | from  | to
        0     | -1    | 1
        0L    | -1L   | 1L
        0.0f  | -1.1f | 1.1f
        0.0d  | -1.1d | 1.1d
        1     | -1    | 1
        1L    | -1L   | 1L
        1.1f  | -1.1f | 1.1f
        1.1d  | -1.1d | 1.1d
        -1    | -1    | 1
        -1L   | -1L   | 1L
        -1.1f | -1.1f | 1.1f
        -1.1d | -1.1d | 1.1d
    }

    @Unroll
    def 'fail to require in-range inclusive: #value'() {
        when:
        NumericArgs.requireInRangeInclusive(value, from, to, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | from  | to
        2     | -1    | 1
        2L    | -1L   | 1L
        2.1f  | -1.1f | 1.1f
        2.1d  | -1.1d | 1.1d
        -2    | -1    | 1
        -2L   | -1L   | 1L
        -2.1f | -1.1f | 1.1f
        -2.1d | -1.1d | 1.1d
    }

    def 'fail to require in-range inclusive: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireInRangeInclusive((Integer) null, 1, 2, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireInRangeInclusive((Long) null, 1L, 2L, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireInRangeInclusive((Float) null, 1f, 2f, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireInRangeInclusive((Double) null, 1d, 2d, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

    /* *************************************************************************
     * require in range exclusive
     * *************************************************************************/

    @Unroll
    def 'successfully require in-range exclusive: #value'() {
        when:
        def result = NumericArgs.requireInRangeExclusive(value, from, to, 'requirement failed')

        then:
        result == value

        where:
        value | from  | to
        0     | -1    | 1
        0L    | -1L   | 1L
        0.0f  | -1.1f | 1.1f
        0.0d  | -1.1d | 1.1d
    }

    @Unroll
    def 'fail to require in-range exclusive: #value'() {
        when:
        NumericArgs.requireInRangeExclusive(value, from, to, 'requirement failed')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        where:
        value | from  | to
        2     | -1    | 1
        2L    | -1L   | 1L
        2.1f  | -1.1f | 1.1f
        2.1d  | -1.1d | 1.1d
        -2    | -1    | 1
        -2L   | -1L   | 1L
        -2.1f | -1.1f | 1.1f
        -2.1d | -1.1d | 1.1d
        1     | -1    | 1
        1L    | -1L   | 1L
        1.1f  | -1.1f | 1.1f
        1.1d  | -1.1d | 1.1d
        -1    | -1    | 1
        -1L   | -1L   | 1L
        -1.1f | -1.1f | 1.1f
        -1.1d | -1.1d | 1.1d
    }

    def 'fail to require in-range exclusive: null'() {
        given:
        def e

        when: 'int'
        NumericArgs.requireInRangeExclusive((Integer) null, 1, 2, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'long'
        NumericArgs.requireInRangeExclusive((Long) null, 1L, 2L, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'float'
        NumericArgs.requireInRangeExclusive((Float) null, 1f, 2f, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'

        when: 'double'
        NumericArgs.requireInRangeExclusive((Double) null, 1d, 2d, 'requirement failed')
        then:
        e = thrown(IllegalArgumentException)
        e.message == 'requirement failed'
    }

}
