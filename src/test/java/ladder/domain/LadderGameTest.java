package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void of() {
        LadderGame ladderGame = LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");

        assertThat(ladderGame.getLadder().getLines()).hasSize(5);

        ladderGame.getLadder()
                .getLines()
                .forEach(line -> assertThat(line.getActionsSize()).isEqualTo(4));
    }

    @Test
    void ladderGame_invalidNameSizeException() {
        assertThatThrownBy(() -> LadderGame.of("pobi,honuxx,crong,jk", "5", "꽝,5000,꽝,3000"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }

    @Test
    void ladderGame_invalidResultSizeException() {
        assertThatThrownBy(() -> LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_RESULT_SIZE.getErrorMessage());
    }
}
