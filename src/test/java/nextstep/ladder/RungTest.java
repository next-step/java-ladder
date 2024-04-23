package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RungTest {
    @ParameterizedTest
    @CsvSource({"false, 0", "true, 1"})
    void rightMove(boolean right, int expected) {
        Rung first = Rung.first(right);

        Assertions.assertThat(first.move()).isEqualTo(expected);
    }

    @Test
    void next() {
        Rung second = Rung.first(true).next();

        Assertions.assertThat(second.move()).isEqualTo(0);
    }

    @Test
    void nextRight() {
        Rung second = Rung.first(false).next(true);

        Assertions.assertThat(second.move()).isEqualTo(2);
    }

    @Test
    void nextLeft() {
        Rung second = Rung.first(true).next(false);

        Assertions.assertThat(second.move()).isEqualTo(0);
    }

    @Test
    void nextPass() {
        Rung second = Rung.first(false).next(false);

        Assertions.assertThat(second.move()).isEqualTo(1);
    }
}
