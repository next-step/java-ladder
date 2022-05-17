package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void nameIsEmpty_ThrowException() {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(LadderException.class);
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(LadderException.class);
    }

    @Test
    void nameLengthIsNotBetween1and5_ThrowException() {
        assertThatThrownBy(() -> new Player("abcedf"))
                .isInstanceOf(LadderException.class);
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(LadderException.class);
    }
}
