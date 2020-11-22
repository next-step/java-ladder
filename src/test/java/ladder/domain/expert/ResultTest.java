package ladder.domain.expert;

import ladder.dto.ResultDto;
import ladder.exception.BadResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultTest {
    @ParameterizedTest
    @DisplayName("5글자가 넘으면, BadNameException 이 발생한다.")
    @ValueSource(strings = {"Bad Result", "나쁜 결과입니다", "666666"})
    void constructor_BadResult(String result) {
        assertThatExceptionOfType(BadResultException.class)
                .isThrownBy(() -> new Result(result));
    }

    @Test
    @DisplayName("Result 의 값이 dto 로 잘 포장되는지 확인")
    void exportResultDto() {
        String value = "n";
        Result result = new Result(value);
        ResultDto dto = result.exportResultDto();
        assertThat(dto.getResult())
                .isEqualTo(value);
    }
}
