package ladder;

import ladder.domain.bridge.Bridge;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.result.Destination;
import ladder.domain.result.Prize;

public class TestHelper {
    public static Player getPlayerHelper(String name, int x) {
        return new Player(new Name(name), new Point(x, 0));
    }

    public static Bridge getBridgeHelper(int x, int y, Direction direction) {
        return new Bridge(new Point(x, y), direction);
    }

    public static Destination getDestinationHelper(int x, int y, String value) {
        return new Destination(new Prize(value), new Point(x, y));
    }
}
