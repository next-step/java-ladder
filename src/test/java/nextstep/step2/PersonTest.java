package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Person;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @ParameterizedTest
    @DisplayName("사람 이름 유효성 체크 - 최대 5자")
    @ValueSource(strings = {"pobi123", "honux1", "crongi", "jklmnop"})
    void InvalidPerson(String name){
        assertThatThrownBy(() -> Person.of(name))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Person.NAME_LIMIT_EXCEPTION);
    }
}
