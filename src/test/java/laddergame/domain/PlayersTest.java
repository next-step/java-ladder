package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_공백(String input) {
        assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    void 생성() {
        assertThat(new Players("a,b,c,d").getPlayers()).containsExactly(
                new Player("a"),
                new Player("b"),
                new Player("c"),
                new Player("d")
        );
    }

    @Test
    void 너비_생성() {
        assertThat(new Players("a,b,c,d").findWidth()).isEqualTo(new Width(3));
    }
}
