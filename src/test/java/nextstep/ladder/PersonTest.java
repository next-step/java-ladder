package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import ladder.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
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

    @ParameterizedTest
    @DisplayName("사람이름 5자 이하 입력시 정상여부 체크")
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    void validPerson(String name){
        Person person = Person.of(name);
        assertThat(person)
                .isEqualTo(Person.of(name));
    }

    @ParameterizedTest
    @DisplayName("사람이름 Null 체크")
    @NullAndEmptySource
    void validPersonName(String inputNullAndEmpty){
        assertThatThrownBy(() -> Person.of(inputNullAndEmpty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Person.NAME_NULL_EXCEPTION);
    }
}
