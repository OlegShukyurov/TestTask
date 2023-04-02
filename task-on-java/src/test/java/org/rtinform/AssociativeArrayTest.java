package org.rtinform;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AssociativeArrayTest {

    private static List<PersonExample> testList;

    @BeforeAll
    static void setUp() {
        PersonExample testPerson1 = new PersonExample(28, "Oleg");
        PersonExample testPerson2 = new PersonExample(28, "Oleg");
        PersonExample testPerson3 = new PersonExample(27, "Marina");
        testList = List.of(testPerson1, testPerson2, testPerson3);
    }

    @Test
    void givenListInteger_whenGetAssociativeArray_thenReturnCorrectAssociativeArray() {
        List<Integer> integerList = List.of(1, 3, 4, 5, 1, 5, 4);
        Map<Object, Integer> expected = Map.of(1, 2, 3, 1, 4, 2, 5, 2);
        Map<Object, Integer> actual = AssociativeArray.getAssociativeArray(integerList);

        assertEquals(expected, actual);
    }

    @Test
    void givenListString_whenGetAssociativeArray_thenReturnCorrectAssociativeArray() {
        List<String> stringList = List.of("one", "three", "four", "five", "one", "five", "four");
        Map<Object, Integer> expected = Map.of("one", 2, "three", 1, "four", 2, "five", 2);
        Map<Object, Integer> actual = AssociativeArray.getAssociativeArray(stringList);

        assertEquals(expected, actual);
    }

    @Test
    void givenListMixedTypes_whenGetAssociativeArray_thenReturnCorrectAssociativeArray() {
        List<Object> anyTypeList = List.of(6, 2, 6, 3, testList.get(0), testList.get(1), testList.get(2));
        Map<Object, Integer> expected = Map.of(testList.get(0), 2, testList.get(2), 1, 6, 2, 2, 1, 3, 1);
        Map<Object, Integer> actual = AssociativeArray.getAssociativeArray(anyTypeList);

        assertEquals(expected, actual);
    }

    @Test
    void givenListNull_whenGetAssociativeArray_thenThrowRuntimeException() {
        Throwable exception = assertThrows(RuntimeException.class, () -> AssociativeArray.getAssociativeArray(null),
                "List should not be null or empty");

        assertEquals("List should not be null or empty", exception.getMessage());
    }
    @Test
    void givenListEmpty_whenGetAssociativeArray_thenThrowRuntimeException() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                        AssociativeArray.getAssociativeArray(Collections.emptyList()),
                "List should not be null or empty");

        assertEquals("List should not be null or empty", exception.getMessage());
    }
}