package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @ParameterizedTest
    @CsvSource(value = {
            "true, RIGHT",
            "false, STRAIGHT"
    })
    @DisplayName("현재 포인트의 방향을 boolean 값으로 으로 정한다.")
    void rightOrStraight_오른쪽_또는_직진(boolean isRight, Direction direction) {
        assertThat(Direction.rightOrStraight(isRight)).isEqualTo(direction);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "LEFT, true, RIGHT",
            "LEFT, false, STRAIGHT",
            "STRAIGHT, true, RIGHT",
            "STRAIGHT, false, STRAIGHT",
            "RIGHT, true, LEFT",
            "RIGHT, false, LEFT"
    })
    @DisplayName("다음 포인트의 방향을 boolean 값으로 결정한다.")
    void next_다음포인트_방향(Direction currentDirection, boolean isRight, Direction nextDirection) {
        assertThat(currentDirection.next(isRight)).isEqualTo(nextDirection);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT, LEFT",
            "STRAIGHT, STRAIGHT",
            "LEFT, STRAIGHT"
    })
    @DisplayName("다음 포인트가 마지막인 경우, 마지막 포인트의 방향을 정한다.")
    void last_마지막_포인트_방향(Direction currentDirection, Direction nextDirection) {
        assertThat(currentDirection.last()).isEqualTo(nextDirection);
    }
}