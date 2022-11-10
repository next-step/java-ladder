package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.text.MessageFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.exception.ErrorMessage;

class NameTest {

    @DisplayName("1~5자 이름을 입력하면 이름이 정상적으로 생성된다.")
    @Test
    void Should_Be_Created_When_Input_String_Between_1_And_5() {
        String nameValue = "a".repeat(5);

        assertThatNoException().isThrownBy(
            () -> {
                Name name = Name.of(nameValue);
            }
        );
    }

    @DisplayName("5자보다 초과하는 이름을 입력하면 이름이 예외를 발생시킨다.")
    @Test
    void Should_Throw_Exception_When_Input_String_Greater_Than_5() {
        final int exceedingLength = 6;
        final String nameValue = "a".repeat(exceedingLength);

        assertThatThrownBy(
            () -> {
                Name name = Name.of(nameValue);
            }
        ).hasMessageContaining(
            MessageFormat.format(ErrorMessage.INVALID_LENGTH_OF_NAME.getMessage(), Name.LENGTH_OF_NAME_MAX_VALUE));
    }
}
