package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PersonTest {

    @Test
    void create() {
        Person person = Person.from("aaa");
        assertThat(person).isNotNull();
    }

    @Test
    void createByNameAndSequence() {
        Person person = Person.of("aaa", 1);
        assertThat(person).isNotNull();
    }
}
