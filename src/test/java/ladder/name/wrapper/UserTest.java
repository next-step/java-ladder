package ladder.name.wrapper;

import ladder.model.ladder.Bridge;
import ladder.model.move.Point;
import ladder.model.name.wrapper.User;
import org.junit.jupiter.api.Test;

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
}
