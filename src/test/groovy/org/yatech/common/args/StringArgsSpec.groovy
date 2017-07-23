package org.yatech.common.args

import spock.lang.Specification
import spock.lang.Unroll

import java.util.regex.Pattern

/**
 * @author Yinon Avraham.
 */
class StringArgsSpec extends Specification {

    @Unroll
    def 'successfully require non blank: "#value"'() {
        when:
        def res = StringArgs.requireNonBlank(value, 'value is blank')

        then:
        value == res

        where:
        value      | _
        'f'        | _
        'foo bar ' | _
        'foo\nbar' | _
    }

    @Unroll
    def 'fail to require non blank: "#value"'() {
        when:
        StringArgs.requireNonBlank(value, 'value is blank')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'value is blank'

        where:
        value | _
        null  | _
        ''    | _
        ' '   | _
        '   ' | _
        '\t'  | _
        '\n'  | _
    }

    @Unroll
    def 'successfully require non empty: "#value"'() {
        when:
        def res = StringArgs.requireNonEmpty(value, 'value is empty')

        then:
        value == res

        where:
        value      | _
        'f'        | _
        ' '        | _
        '\t'       | _
        '\n'       | _
        'foo bar ' | _
        'foo\nbar' | _
    }

    @Unroll
    def 'fail to require non empty: "#value"'() {
        when:
        StringArgs.requireNonEmpty(value, 'value is empty')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'value is empty'

        where:
        value | _
        null  | _
        ''    | _
    }

    @Unroll
    def 'successfully require matches: "#value", pattern: #pattern'() {
        when:
        def res = StringArgs.requireMatches(value, pattern, 'value pattern mismatch')

        then:
        value == res

        where:
        value         | pattern
        'foo bar 123' | ~/.*/
        'foo bar 123' | ~/[a-z 0-9]+/
        '1234'        | ~/\d+/
    }

    @Unroll
    def 'fail to require matches: "#value", pattern: #pattern'() {
        when:
        StringArgs.requireMatches(value, pattern, 'value pattern mismatch')

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'value pattern mismatch'

        where:
        value | pattern
        null  | ~/.*/
        ''    | ~/\d/
        'foo' | ~/\d+/
        '123' | ~/[a-z]+/
    }

}
