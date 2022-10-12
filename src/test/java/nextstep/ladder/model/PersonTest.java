package nextstep.ladder.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    void create(String name) {
        Person person = new Person(name);
    }

    @Test
    void createWithEmptyOrNullName() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> new Person(null)),
            () -> assertThrows(IllegalArgumentException.class, () -> new Person("")),
            () -> assertThrows(IllegalArgumentException.class, () -> new Person(" "))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcedf", "veryverylongstring"})
    void createWithNameExceeding5Length(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Person(name));
    }
}
