package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RungTest {
    @Test
    void rightMove() {
        Rung rung = new Rung(0, Direction.of(false, true));

        Assertions.assertThat(rung.move()).isEqualTo(1);
    }

    @Test
    void passMove() {
        Rung rung = new Rung(0, Direction.of(false, false));

        Assertions.assertThat(rung.move()).isEqualTo(0);
    }
}
