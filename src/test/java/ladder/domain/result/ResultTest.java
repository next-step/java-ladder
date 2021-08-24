package ladder.domain.result;

import ladder.exception.EmptyResultValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Result Test")
class ResultTest {

    @Test
    @DisplayName("Result 생성")
    void generate() {
        // given
        String given = "꽝";

        // when
        Result result = new Result(given);

        // then
        assertThat(result).isEqualTo(new Result(given));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("결과 값이 null 또는 빈값일경우 Exception")
    void nullAndEmptyGenerateException(String value) {
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(EmptyResultValueException.class);
    }
}