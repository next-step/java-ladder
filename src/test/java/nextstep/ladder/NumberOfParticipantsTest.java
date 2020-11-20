package nextstep.ladder;

import nextstep.ladder.domain.NumberOfParticipants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberOfParticipantsTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("NumberOfParticipants 생성시에 value값이 2보다 작은 숫자면 throw Exception")
    void numberOfParticipantsTestFailureCase(int inputValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> NumberOfParticipants.valueOf(inputValue))
                .withMessage(NumberOfParticipants.INPUT_VALUE_RANGE_ERR_MSG);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 100})
    @DisplayName("NumberOfParticipants 생성시에 value값은 2이상의 정수여야 한다.")
    void numberOfParticipantsTestSuccessCase(int inputValue) {
        assertThatCode(() -> NumberOfParticipants.valueOf(inputValue))
                .doesNotThrowAnyException();
    }
}
