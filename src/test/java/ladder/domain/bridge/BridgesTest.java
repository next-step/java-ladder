package ladder.domain.bridge;

import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static ladder.TestHelper.getBridgeHelper;
import static org.assertj.core.api.Assertions.assertThat;

class BridgesTest {

    private static Stream<Arguments> getDummyBridges() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(1, 3);
        Bridges heightTwoBridge = new Bridges(Arrays.asList(new Bridge(point1, Direction.DOWN),
                new Bridge(point2, Direction.RIGHT)));
        Bridges heightThreeBridge = new Bridges(Arrays.asList(new Bridge(point1, Direction.DOWN),
                new Bridge(point2, Direction.LEFT),
                new Bridge(point3, Direction.RIGHT)));

        return Stream.of(
                Arguments.of(heightTwoBridge, 2),
                Arguments.of(heightThreeBridge, 3));
    }

    @ParameterizedTest
    @CsvSource({"1,1,DOWN", "2,1,LEFT", "3,1,RIGHT"})
    void 좌표로_방향찾기(Integer x, Integer y, String directionName) {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 1);
        Point point3 = new Point(3, 1);
        Bridges bridges = new Bridges(Arrays.asList(new Bridge(point1, Direction.DOWN),
                new Bridge(point2, Direction.LEFT),
                new Bridge(point3, Direction.RIGHT)));

        assertThat(bridges.findDirection(new Point(x, y))).isEqualTo(Direction.valueOf(directionName));
    }

    @ParameterizedTest
    @MethodSource("getDummyBridges")
    void 사다리의_높이구하기(Bridges bridges, int answer) {
        assertThat(bridges.getHeight()).isEqualTo(answer);
    }

    @Test
    void 마지막점찾기() {
        Bridge leftFirst = getBridgeHelper(0, 1, Direction.RIGHT);
        Bridge leftSecond = getBridgeHelper(0, 2, Direction.DOWN);
        Bridge leftThird = getBridgeHelper(0, 3, Direction.RIGHT);

        Bridge rightFirst = getBridgeHelper(1, 1, Direction.LEFT);
        Bridge rightSecond = getBridgeHelper(1, 2, Direction.DOWN);
        Bridge rightThird = getBridgeHelper(1, 3, Direction.LEFT);

        Bridges bridges = new Bridges(Arrays.asList(leftFirst, leftSecond, leftThird, rightFirst, rightSecond, rightThird));

        Point startedLeft = bridges.findDestinationPoint(new Point(0, 1));
        Point startedRight = bridges.findDestinationPoint(new Point(1, 1));

        assertThat(startedLeft).isEqualTo(new Point(0, 4));
        assertThat(startedRight).isEqualTo(new Point(1, 4));
    }
}