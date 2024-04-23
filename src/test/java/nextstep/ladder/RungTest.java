package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RungTest {
    @ParameterizedTest
    @CsvSource({"0, false, 0", "0, true, 1"})
    void rightMove(int position, boolean right, int expected) {
        Rung rung = new Rung(position, Direction.first(right));

        Assertions.assertThat(rung.move()).isEqualTo(expected);
    }

    @Test
    void next() {
        Rung rung = new Rung(1, Direction.first(true).next());

        Assertions.assertThat(rung.move()).isEqualTo(0);
    }

}
