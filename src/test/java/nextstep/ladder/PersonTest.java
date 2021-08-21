package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @DisplayName("주어진 수로 사람들을 만든다")
    @Test
    void person() {
        Person person = Person.of("Phobi");

        assertThat(person.getName()).isEqualTo("Phobi");
    }
}
