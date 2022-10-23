package nextstep.ladder.Model;

import nextstep.ladder.Strategy.ConnectBridgeStrategy;

import java.util.Objects;

public class Bridge {

    private static final String INVALID_BRIDGE_ERROR = "연결할 때 연속으로 연결할 수 없습니다.";
    private final boolean right;
    private final boolean left;

    private Bridge(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(INVALID_BRIDGE_ERROR);
        }
        this.left = left;
        this.right = right;
    }

    public static Bridge first(ConnectBridgeStrategy connectBridgeStrategy) {
        return new Bridge(false, connectBridgeStrategy.makeBridge());
    }

    public Bridge next(ConnectBridgeStrategy connectBridgeStrategy) {
        if(this.right){
            return new Bridge(this.right, false);
        }
        return new Bridge(this.right, connectBridgeStrategy.makeBridge());
    }

    public Direction move() {
        if (right) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.PASS;
    }
    public boolean getLeftConnectInfo(){
        return this.left;
    }

    public Bridge last() {
        return new Bridge(this.right, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bridge)) return false;
        Bridge bridge = (Bridge) o;
        return right == bridge.right && left == bridge.left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(right, left);
    }
}
