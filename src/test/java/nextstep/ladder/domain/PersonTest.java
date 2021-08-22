package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {

    @DisplayName("주어진 수로 사람들을 만든다")
    @Test
    void person() {
        Person person = Person.of("Phobi");

        assertThat(person.getName()).isEqualTo("Phobi");
    }

    @ParameterizedTest(name = "5글자 미만이면 5글자로 만든다")
    @ValueSource(strings = {"phob", "pho", "ph"})
    void addNameWithBlank(String name) {
        Person givenPerson = Person.of(name);

        assertThat(givenPerson.getName().length()).isEqualTo(5);
    }

    @DisplayName("사람이 이름은 최대 5글자 초과이면 IllegalArgument 발생")
    @Test
    void personWithIllegalArguments() {
        assertThatIllegalArgumentException().isThrownBy(() -> Person.of("Phobi2"));
    }
}
