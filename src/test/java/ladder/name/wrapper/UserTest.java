package ladder.name.wrapper;

import ladder.model.ladder.Bridge;
import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;
import ladder.model.move.Point;
import ladder.model.name.wrapper.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void isCross(){
        Bridge leftBridge = Bridge.createMovableBridge(Point.bridgePoint(1,0));
        User user = User.of("A", 1);
        Bridge rightBridge = Bridge.createMovableBridge(Point.bridgePoint(2,0));

        assertThat(user.isCross(leftBridge)).isTrue();
        assertThat(user.isCross(rightBridge)).isTrue();
    }

    @Test
    public void isNotCross(){
        Bridge nonCrossLeftBridge = Bridge.createMovableBridge(Point.bridgePoint(1,0));
        User user = User.of("A", 2);
        Bridge nonCrossRightBridge = Bridge.createMovableBridge(Point.bridgePoint(4,0));

        assertThat(user.isCross(nonCrossLeftBridge)).isFalse();
        assertThat(user.isCross(nonCrossRightBridge)).isFalse();
    }

    @Test
    public void move(){
        User crossUser = User.of("A", 0);
        User nonCrossUser = User.of("B", 2);

        List<Point> points = IntStream.rangeClosed(1,2)
                .mapToObj(idx -> Point.bridgePoint(idx,0))
                .collect(Collectors.toList());

        List<Bridge> bridges = Arrays.asList(
                Bridge.createMovableBridge(points.get(0)),
                Bridge.createNonMovableBridge(points.get(1))
                );

        Line line = Line.from(bridges);

        assertThat(crossUser.move(line)).isEqualTo(Point.of(2,1));
        assertThat(nonCrossUser.move(line)).isEqualTo(Point.of(4,1));
    }
}
