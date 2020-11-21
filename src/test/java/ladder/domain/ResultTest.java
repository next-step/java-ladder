package ladder.domain;

import ladder.exception.BadResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultTest {

    @ParameterizedTest
    @DisplayName("5글자가 넘으면, BadNameException 이 발생한다.")
    @ValueSource(strings = {"Bad Result", "나쁜 결과입니다", "666666"})
    void getResultDto(String result) {
        assertThatExceptionOfType(BadResultException.class)
                .isThrownBy(() -> new Result(result));
    }
}
