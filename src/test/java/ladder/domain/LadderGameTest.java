package ladder.domain;

import ladder.Exception.ExceptionType;
import ladder.Exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void ladderGame() {
        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", "5");

        assertThat(ladderGame.getLadder().getLines()).hasSize(5);

        ladderGame.getLadder()
                .getLines()
                .forEach(line -> assertThat(line.getPoints()).hasSize(4));
    }

    @Test
    void ladderGame_Exception() {
        assertThatThrownBy(() -> new LadderGame("pobi,honuxx,crong,jk", "5"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }
}
