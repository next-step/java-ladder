package ladder;

import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {

    @Test
    void Person_객체_생성() {
        String name = "java";
        Person person = new Person(name);

        assertThat(person.getName()).isEqualTo(name);
    }

    @Test
    void 이름_길이_예외() {
        String nameOver = "player";

        assertThatThrownBy(() -> new Person(nameOver))
                .isInstanceOf(IllegalArgumentException.class);
    }
}