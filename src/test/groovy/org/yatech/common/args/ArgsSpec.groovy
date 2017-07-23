package org.yatech.common.args

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Yinon Avraham.
 */
class ArgsSpec extends Specification {

    @Unroll
    def 'successfully require non null: "#value"'() {
        when:
        def res = Args.requireNonNull(value, 'value is null')

        then:
        value == res

        where:
        value        | _
        ''           | _
        'foo'        | _
        0            | _
        7L           | _
        true         | _
        false        | _
        new Object() | _
    }

    def 'fail to require non null'() {
        when:
        Args.requireNonNull(null, 'value is null')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'value is null'
    }
}