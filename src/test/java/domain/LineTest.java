package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class LineTest {
    @Test
    @DisplayName("fromWithStrategy 호출 시 매개변수로 정수(참가자 수)와 points 생성 전략을 받아 Line 반환")
    void create() {
        assertThatNoException().isThrownBy(() -> Line.from(5, (playerCount) -> List.of(true, false, true, false, true)));
    }

    @ParameterizedTest
    @MethodSource("playerPointAndPointDirection")
    @DisplayName("checkPointDirection 호출 시 현재 플레이어 기준 수평 사다리의 방향 반환")
    void checkPointDirection(int playerPoint, PointDirection expectedDirection) {
        Line line = Line.from(6, (playerCount) -> List.of(true, false, false, false, true));
        PointDirection pointDirection = line.checkPointDirection(playerPoint);
        assertThat(pointDirection).isEqualTo(expectedDirection);
    }

    static Stream<Arguments> playerPointAndPointDirection() {
        return Stream.of(
                Arguments.arguments(0, PointDirection.RIGHT),
                Arguments.arguments(1, PointDirection.LEFT),
                Arguments.arguments(2, PointDirection.NONE),
                Arguments.arguments(3, PointDirection.NONE),
                Arguments.arguments(4, PointDirection.RIGHT),
                Arguments.arguments(5, PointDirection.LEFT)
        );
    }
}
