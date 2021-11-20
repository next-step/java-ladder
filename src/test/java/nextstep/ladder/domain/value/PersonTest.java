package nextstep.ladder.domain.value;

import nextstep.ladder.doamin.value.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PersonTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    @DisplayName("참가자 정상 생성 검증")
    void create(String name) {
        assertDoesNotThrow(() -> Person.from(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 공백이나 null인 경우 예외 발생 검증")
    void create_exception(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Person.from(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aidenn", "심심준준보보"})
    @DisplayName("이름이 5자가 넘어가면 예외 발생 검증")
    void create_exception_2(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Person.from(name));
    }

    @Test
    @DisplayName("사용자가 'all' 입력여부 검증")
    void isAll() {
        Person result = Person.from("all");
        assertThat(result.isAll()).isTrue();
    }
}
