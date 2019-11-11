package ladder.domain.direction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @CsvSource({"true,RIGHT", "false,DOWN"})
    void 방향_만들기_테스트(boolean isRight, String directionName) {
        FixedWay fixedWay = new FixedWay(isRight);
        assertThat(Direction.getDirection(fixedWay)).isEqualTo(Direction.valueOf(directionName));
    }
}