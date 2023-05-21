package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PersonTest {


    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @NullAndEmptySource
    void 입력값검증_NullAndEmpty(String name) {
        assertThatThrownBy(() -> {
            Person person = new Person(name);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름이 Null 또는 빈값이 입력되었습니다.");
    }

    @Test
    void 입력값검증_이름최대길이() {
        assertThatThrownBy(() -> {
            Person person = new Person("ethann");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름이 최대허용길이(5)를 초과하였습니다");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @ValueSource(strings = {"j", "jerry"})
    void 정상생성검증(String name) {
        Assertions.assertThat(new Person(name)).isEqualTo(name);
    }
}
