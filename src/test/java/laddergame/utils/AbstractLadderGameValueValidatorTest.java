package laddergame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AbstractLadderGameValueValidatorTest {

    @DisplayName("문자열이 null이거나 공백이면 예외가 발생해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validate_givenEmptyOrNull(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> AbstractLadderGameValueValidator.validate(value));
    }

    @DisplayName("문자열의 길이가 최대 허용 길이를 초과하면 예외가 발생해야 한다.")
    @Test
    void validate_givenLengthOverMaxLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> AbstractLadderGameValueValidator.validate("abcdef"));
    }

}
