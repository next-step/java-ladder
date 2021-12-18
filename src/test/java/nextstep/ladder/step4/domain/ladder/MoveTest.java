package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MoveTest {

    @Test
    void left() {
        assertThat(Move.of(Direction.first(TRUE).last()).move(1)).isEqualTo(0);
    }

    @Test
    void stop() {
        assertThat(Move.of(Direction.first(FALSE)).move(1)).isEqualTo(1);
    }

    @Test
    void right() {
        assertThat(Move.of(Direction.first(TRUE)).move(1)).isEqualTo(2);
    }

}
