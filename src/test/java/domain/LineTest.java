package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class LineTest {
    @Test
    @DisplayName("fromWithStrategy 호출 시 매개변수로 정수(참가자 수)와 points 생성 전략을 받아 Line 반환")
    void create() {
        assertThatNoException().isThrownBy(() -> Line.from(5, (playerCount) -> getPoints(true, false, true, false, true)));
    }

    @ParameterizedTest
    @MethodSource("playerAndPointDirection")
    @DisplayName("checkPointDirection 호출 시 현재 플레이어 기준 수평 사다리의 방향 반환")
    void checkPointDirection(Player player, PointDirection expectedDirection) {
        Line line = Line.from(6, (playerCount) -> getPoints(true, false, false, false, true, false));
        PointDirection pointDirection = line.checkPointDirection(player);
        assertThat(pointDirection).isEqualTo(expectedDirection);
    }
    private static List<Point> getPoints(boolean... pointArr) {
        List<Point> points = new ArrayList<>();
        boolean previousBoolean = false;
        for (boolean b : pointArr) {
            points.add(Point.of(previousBoolean, b));
            previousBoolean = b;
        }

        return points;
    }

    static Stream<Arguments> playerAndPointDirection() {
        return Stream.of(
                Arguments.arguments(Player.of("nimoh",0) , PointDirection.RIGHT),
                Arguments.arguments(Player.of("sera",1), PointDirection.LEFT),
                Arguments.arguments(Player.of("pobi",2), PointDirection.DOWN),
                Arguments.arguments(Player.of("jane",3), PointDirection.DOWN),
                Arguments.arguments(Player.of("yona",4), PointDirection.RIGHT),
                Arguments.arguments(Player.of("jinx",5), PointDirection.LEFT)
        );
    }
}
