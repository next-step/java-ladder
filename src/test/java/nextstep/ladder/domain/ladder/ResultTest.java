package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @DisplayName("공백이거나 문자열이 비어있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void resultException(String input) {
        assertThatThrownBy(() -> new Result(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 길이가 5 초과인 경우 예외가 발생한다.")
    @Test
    void resultSizeException() {
        assertThatThrownBy(() -> new Result("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
