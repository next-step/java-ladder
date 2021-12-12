package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("5글자 이하의 이름 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"k", "kj", "kjh", "hana", "kimja"})
    void createName(String inputName) {
        Name name = new Name(inputName);

        assertThat(inputName).isEqualTo(name.getValue());
    }

    @DisplayName("5글자를 초과, 공백 또는 빈 값의 이름을 생성하면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"jaeHan"})
    void createNameException(String inputName) {
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열의 값이 유효하지 않습니다.");
    }
}
