package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_공백(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    void 이름_5글자_초과() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.NAME_OVER_MAXMUM_LENGTH.getMessage());
    }

    @Test
    void 이름_5글자() {
        assertThatNoException().isThrownBy(() -> new Player("abcde"));
    }
}
