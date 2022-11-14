package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 생성(String input) {
        assertThatThrownBy(() -> new Result(input))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_INPUT.getMessage());
    }
}
