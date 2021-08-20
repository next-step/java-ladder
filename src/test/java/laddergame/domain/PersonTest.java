package laddergame.domain;

import laddergame.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PersonTest {

    @Test
    void create() {
        // given
        String name = "hwan";

        // when
        Person person = new Person(name);

        // then
        assertThat(person.getName()).isEqualTo(name);
    }

    @Test
    void create_fail_null_or_empty_string() {
        // given
        String name1 = "";
        String name2 = null;

        // when, then
        assertThatThrownBy(() -> new Person(name1))
                .isInstanceOf(CustomException.class);
        assertThatThrownBy(() -> new Person(name2))
                .isInstanceOf(CustomException.class);
    }

    @Test
    void create_fail_over_length_of_name() {
        // given
        String name = "abcdef";

        // when, then
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(CustomException.class);
    }


}