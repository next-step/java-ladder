package laddergame.domain;

import laddergame.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("Person 생성")
    void create() {
        // given
        String name = "hwan";

        // when
        Person person = new Person(name);

        // then
        assertThat(person.getName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "Person 생성 실패 empty string")
    @ValueSource(strings = {"", "  "})
    void create_fail_empty_string(String name) {
        // when, then
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Person.EMPTY_STRING_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("Person 생성 실패 null")
    void create_fail_null() {
        // when, then
        assertThatThrownBy(() -> new Person(null))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Person.EMPTY_STRING_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("Person 생성 실패 글자수 초과")
    void create_fail_over_length_of_name() {
        // given
        String name = "abcdef";

        // when, then
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Person.LENGTH_OF_NAME_EXCEPTION_MESSAGE);
    }


}