package nextstep.ladder;

import nextstep.ladder.domain.ResultCandidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ResultCandidateTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("실행결과 입력값이 1글자 미만 5글자 초과면 throw Exception")
    void nameTestFailureCase(String invalidResult) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ResultCandidate.valueOf(invalidResult));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    @DisplayName("실행결과 입력값의 유효한 길이는 1글자 이상 5글자 이하다.")
    void nameTestSuccessCase(String validResult) {
        assertThatCode(() -> ResultCandidate.valueOf(validResult))
                .doesNotThrowAnyException();
    }
}
