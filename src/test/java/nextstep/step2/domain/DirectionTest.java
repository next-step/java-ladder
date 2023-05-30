package nextstep.step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @CsvSource({"LEFT,-1", "RIGHT,1"})
    void Direction_위치(Direction direction, int expected) {
        final var actual = direction.nextPosition();

        assertThat(actual).isEqualTo(expected);
    }

}
