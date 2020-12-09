package ladder.ladder;

import ladder.model.ladder.Bridge;
import ladder.model.move.Direction;
import ladder.model.move.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private Bridge movableBridge = Bridge.createMovableBridge(Point.bridgePoint(1,0));
    private Bridge nonMovableBridge = Bridge.createNonMovableBridge(Point.bridgePoint(1,0));

    @Test
    public void 다리_이동_가능(){
        assertThat(movableBridge.isMovable()).isTrue();
        assertThat(nonMovableBridge.isMovable()).isFalse();
    }

    @Test
    public void 다리_방향(){
        Point left = Point.userPoint(0);
        Point right = Point.userPoint(1);

        assertThat(movableBridge.directionByUser(left)).isEqualTo(Direction.RIGHT);
        assertThat(movableBridge.directionByUser(right)).isEqualTo(Direction.LEFT);
    }
}
