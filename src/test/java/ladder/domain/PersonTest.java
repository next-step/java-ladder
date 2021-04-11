package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void create() {
        // given
        String name = "snow";

        // when
        Person person = Person.from(name);

        // then
        assertThat(person).isEqualTo(Person.from(name));
    }
}