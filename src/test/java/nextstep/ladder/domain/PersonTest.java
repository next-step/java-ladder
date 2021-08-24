package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {

    @DisplayName("주어진 수로 사람들을 만든다")
    @Test
    void person() {
        Person person = Person.of("Phobi");

        assertThat(person.getName()).isEqualTo("Phobi");
    }

    @DisplayName("사람이 이름은 최대 5글자 초과이면 IllegalArgument 발생")
    @Test
    void personWithIllegalArguments() {
        assertThatIllegalArgumentException().isThrownBy(() -> Person.of("Phobi2"));
    }
}
