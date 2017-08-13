package org.yatech.common.collection.sqlike;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.yatech.common.collection.sqlike.OrderByUtil.asc;
import static org.yatech.common.collection.sqlike.OrderByUtil.desc;
import static org.yatech.common.collection.sqlike.Predicates.*;
import static org.yatech.common.collection.sqlike.Predicates.StringPredicates.*;
import static org.yatech.common.collection.sqlike.SqlLikeCollections.selectFrom;

public class QueryableArrayListTest {

    private static final Comparator<String> LEXICOGRAPHIC_ORDER = new Comparator<String>() {
        @Override
        public int compare(String e1, String e2) {
            return e1.compareTo(e2);
        }
    };

    @Test
    public void testWhereReturnAll() {
        List<String> original = Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(alwaysTrue(String.class));
        assertArrayEquals("Result list is not as expected", original.toArray(), result.toArray());
    }

    @Test
    public void testWhereReturnNone() {
        List<String> original = Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(alwaysFalse(String.class));
        assertArrayEquals("Result list is not as expected", new String[]{}, result.toArray());
    }

    @Test
    public void testWhereNotNull() {
        List<String> original = Arrays.asList(
                null, "A", "B", "C", null, "D", "E", "F", "G", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(not(isNull(String.class)));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereNull() {
        List<String> original = Arrays.asList(
                null, "A", "B", "C", null, "D", "E", "F", "G", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                null, null, null
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(isNull(String.class));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereNotNullOrEmpty() {
        List<String> original = Arrays.asList(
                "", "A", "B", "C", null, "D", "", "E", "F", "G", "", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(
                                not(
                                        or(
                                                emptyString(),
                                                isNull(String.class)
                                        )
                                )
                        );
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereIn() {
        List<String> original = Arrays.asList(
                "", "A", "B", "C", null, "D", "", "E", "F", "G", "", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(in(expected));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereInWithNull() {
        List<String> original = Arrays.asList(
                "", "A", "B", "C", null, "D", "", "E", "F", "G", "", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C", null, "D", "E", "F", "G", "H", "I", null
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(in(null, "A", "B", "C", "D", "E", "F", "G", "H", "I"));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

	/*
	 * STRING PREDICATES
	 */

    @Test
    public void testWhereStringEquals() {
        List<String> original = Arrays.asList(
                "", "A", "B", "C", null, "D", "", "E", "F", "G", "", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(
                                or(
                                        stringEquals("A"),
                                        stringEquals("B"),
                                        stringEquals("C")
                                )
                        );
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereStringMatches() {
        List<String> original = Arrays.asList(
                "", "A", "B", "C", null, "D", "", "E", "F", "G", "", "H", "I", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(stringMatches("A|B|C"));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereStringStartsWith() {
        List<String> original = Arrays.asList(
                "", "Alpha", "Beta", "Charlie", null, "Delta", "", "Echo", "Fox", "Global", "", "Hello", "Israel", null
        );
        List<String> expected = Arrays.asList(
                "Delta"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(stringStartsWith("Del"));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereStringEndsWith() {
        List<String> original = Arrays.asList(
                "", "Alpha", "Beta", "Charlie", null, "Delta", "", "Echo", "Fox", "Global", "", "Hello", "Israel", null
        );
        List<String> expected = Arrays.asList(
                "Alpha", "Beta", "Delta"
        );
        QueryableCollection<String> result =
                selectFrom(original)
                        .where(stringEndsWith("a"));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereStringContains() {
        List<String> original = Arrays.asList(
                "", "Alpha", "Beta", "Charlie", null, "Delta", "", "Echo", "Fox", "Global", "", "Hello", "Israel", null
        );
        List<String> expected = Arrays.asList(
                "Alpha", "Global"
        );
        Collection<String> result =
                selectFrom(original)
                        .where(
                                and(
                                        stringContains("l"),
                                        not(stringContains("e"))
                                )
                        );
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereStringBetween() {
        List<String> original = Arrays.asList(
                "", "Alpha", "Beta", "Charlie", null, "Delta", "", "Echo", "Fox", "Global", "", "Hello", "Israel", null
        );
        List<String> expected = Arrays.asList(
                "Delta", "Echo", "Fox"
        );
        Collection<String> result =
                selectFrom(original)
                        .where(
                                and(
                                        not(isNull(String.class)),
                                        stringFollows("Charlie"),
                                        stringPrecedes("Global")
                                )
                        );
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWhereNotNullOrderByLexi() {
        List<String> original = Arrays.asList(
                null, "H", "E", "I", null, "B", "D", "F", "G", "A", "C", null
        );
        List<String> expected = Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I"
        );
        List<String> result =
                selectFrom(original)
                        .where(not(isNull(String.class)))
                        .orderBy(LEXICOGRAPHIC_ORDER);
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

	/*
	 * COMPLEX ELEMENTS - PERSON
	 */

    @Test
    public void testWherePersonMockAttributes() {
        List<Person> original = Arrays.asList(
                new Person("name1", 1, 1.1),
                new Person("name2", 2, 2.2),
                new Person(null, -1, -1),
                new Person("name3", 3, 3.3),
                new Person("", 0, 0),
                new Person("name4", 4, 4.4)
        );
        List<Person> expected = Arrays.asList(
                new Person("name1", 1, 1.1),
                new Person("name3", 3, 3.3),
                new Person("name4", 4, 4.4)
        );
        Collection<Person> result =
                selectFrom(original)
                        .where(
                                and(
                                        not(isNull(Person.name())),
                                        not(in(Person.age(), Arrays.asList(0, 2)))
                                )
                        );
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWherePersonMockStringAttributes() {
        List<Person> original = Arrays.asList(
                new Person("name1", 1, 1.1),
                new Person("name2", 2, 2.2),
                new Person(null, -1, -1),
                new Person("name3", 3, 3.3),
                new Person("", 0, 0),
                new Person("name4", 4, 4.4)
        );
        List<Person> expected = Arrays.asList(
                new Person("name2", 2, 2.2),
                new Person(null, -1, -1),
                new Person("", 0, 0)
        );
        Collection<Person> result =
                selectFrom(original)
                        .where(
                                or(
                                        isNull(Person.name()),
                                        stringEndsWith(Person.name(), "2"),
                                        lessThanOrEquals(Person.age(), 0)
                                )
                        );
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testWherePersonMockNameNotNullOrEmptyOrderByName() {
        List<Person> original = Arrays.asList(
                new Person("name2", 2, 2.2),
                new Person("name1", 1, 1.1),
                new Person(null, -1, -1),
                new Person("name4", 4, 4.4),
                new Person("", 0, 0),
                new Person("name3", 3, 3.3)
        );
        List<Person> expected = Arrays.asList(
                new Person("name1", 1, 1.1),
                new Person("name2", 2, 2.2),
                new Person("name3", 3, 3.3),
                new Person("name4", 4, 4.4)
        );
        Collection<Person> result =
                selectFrom(original)
                        .where(
                                and(
                                        not(isNull(Person.name())),
                                        not(emptyString(Person.name()))
                                )
                        )
                        .orderBy(Person.name());
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

    @Test
    public void testPersonMockOrderByAgeDescNameAsc() {
        List<Person> original = Arrays.asList(
                new Person("name2", 2, 2.2),
                new Person("name1", 1, 1.1),
                new Person("name4", 4, 4.4),
                new Person("name3", 1, 3.3),
                new Person("name5", 2, 5.5),
                new Person("name6", 3, 6.6)
        );
        List<Person> expected = Arrays.asList(
                new Person("name4", 4, 4.4),
                new Person("name6", 3, 6.6),
                new Person("name2", 2, 2.2),
                new Person("name5", 2, 5.5),
                new Person("name1", 1, 1.1),
                new Person("name3", 1, 3.3)
        );
        Collection<Person> result =
                selectFrom(original)
                        .orderBy(desc(Person.age()),
                                asc(Person.name()));
        assertArrayEquals("Result list is not as expected", expected.toArray(), result.toArray());
    }

}
