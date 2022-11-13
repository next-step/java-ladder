package laddergame.util;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_공백(String input) {
        assertThatThrownBy(() -> Parser.parse(input, ","))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    void 파싱_성공() {
        assertThat(Parser.parse("a,b,c,d", ",")).containsExactly("a", "b", "c", "d");
    }
}
