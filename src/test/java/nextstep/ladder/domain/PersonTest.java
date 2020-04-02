package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @DisplayName("이름에 따라 유저 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"dong", "chul"})
    void createPerson(String name) {
        Person person = Person.of(name);

        assertThat(person.getName()).isEqualTo(name);
    }

    @DisplayName("이름이 공백이거나 Null인 경우 생성 실패")
    @ParameterizedTest
    @NullAndEmptySource
    void createPersonFailByNullAndEmpty(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Person.of(name));
    }

    @DisplayName("이름이 5글자 초과할 경우 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"dongch"})
    void createPersonFailByNameLength(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Person.of(name));
    }
}
