package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void ladderGame() {
        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");

        assertThat(ladderGame.getLadder().getLines()).hasSize(5);

        ladderGame.getLadder()
                .getLines()
                .forEach(line -> assertThat(line.getActions()).hasSize(4));
    }

    @Test
    void ladderGame_invalid_name_size_Exception() {
        assertThatThrownBy(() -> new LadderGame("pobi,honuxx,crong,jk", "5", "꽝,5000,꽝,3000"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }

    @Test
    void ladderGame_invalid_result_size_Exception() {
        assertThatThrownBy(() -> new LadderGame("pobi,honux,crong,jk", "5", "꽝,5000,꽝"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_RESULT_SIZE.getErrorMessage());
    }
}
