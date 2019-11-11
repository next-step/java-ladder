package ladder.domain.bridge;

import org.junit.jupiter.api.Test;
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

    @Test
    public void 이전_방향이_오른쪽일때_왼쪽방향_만들기_테스트() {
        Direction middleDirection = Direction.getMiddleDirection(new RandomWay(), Direction.RIGHT);

        assertThat(middleDirection).isEqualTo(Direction.LEFT);
    }

    @ParameterizedTest
    @CsvSource({"LEFT,DOWN", "DOWN,DOWN", "RIGHT,LEFT"})
    public void 마지막_방향_만들기_테스트(String beforeName, String lastName) {
        Direction lastDirection = Direction.getLastDirection(Direction.valueOf(beforeName));

        assertThat(lastDirection).isEqualTo(Direction.valueOf(lastName));
    }
}