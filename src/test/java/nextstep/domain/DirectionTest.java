package nextstep.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "LEFT,-1",
            "PASS,0",
            "RIGHT,1"
    })
    void isDirections(Direction direction, int point) {
        assertThat(direction.moveDirections()).isEqualTo(point);
    }
}
