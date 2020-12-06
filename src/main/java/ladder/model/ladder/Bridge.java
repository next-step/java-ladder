package ladder.model.ladder;

import ladder.model.move.Direction;
import ladder.model.move.Point;
import utils.RandomUtils;

import java.util.Objects;

public class Bridge {
    private final Point point;
    private final LadderItem ladderItem;

    private Bridge(Point point, LadderItem ladderItem) {
        this.point = point;
        this.ladderItem = ladderItem;
    }

    public static Bridge createMovableBridge(Point point) {
        return new Bridge(point, LadderItem.HORIZONTAL);
    }

    public static Bridge createNonMovableBridge(Point point) {
        return new Bridge(point, LadderItem.BLANK_HORIZONTAL);
    }

    public static Bridge createRandomBridge(Point point) {
        return new Bridge(point, LadderItem.findItem(RandomUtils.getZeroOrOne()));
    }

    public boolean isMovable() {
        return ladderItem.equals(LadderItem.HORIZONTAL);
    }

    public Direction directionByUser(Point userPoint) {
        return Point.direction(userPoint, point);
    }

    public boolean isCross(Point point){
        return Point.isMovable(point, this.point);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bridge) {
            return this.ladderItem.equals(((Bridge) obj).ladderItem);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, ladderItem);
    }

    @Override
    public String toString() {
        return ladderItem.getItem();
    }
}
