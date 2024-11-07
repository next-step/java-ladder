package nextstep.ladder.domain;

public class Line {
    private static final boolean CONNECTED = true;
    private static final boolean DISCONNECTED = false;

    private boolean left = DISCONNECTED;
    private boolean right = DISCONNECTED;

    public Line() {

    }

    public static Line first() {
        return new Line(CONNECTED, DISCONNECTED);
    }

    public static Line last() {
        return new Line(DISCONNECTED, CONNECTED);
    }

    public static Line firstAndLast() {
        return new Line(CONNECTED, CONNECTED);
    }

    private Line(boolean left, boolean right) {
        checkLeftAndRightALLConnected(left, right);
        this.left = left;
        this.right = right;
    }

    private void checkLeftAndRightALLConnected(boolean left, boolean right) {
        if (left == CONNECTED && right == CONNECTED) {
            throw new IllegalArgumentException("연속으로 연결된 라인은 생성할 수 없습니다");
        }
    }

    public void connectRight() {
        if (isLeftConnected()) {
            return;
        }
        right = CONNECTED;
    }

    public void connectLeft() {
        if (isRightConnected()) {
            return;
        }
        left = CONNECTED;
    }

    public int tryMove(int location) {
        location = tryMoveRight(location);
        location = tryMoveLeft(location);
        return location;
    }

    private int tryMoveRight(int location) {
        if (isRightConnected()) {
            return ++location;
        }
        return location;
    }

    private int tryMoveLeft(int location) {
        if (isLeftConnected()) {
            return --location;
        }
        return location;
    }

    public boolean isLeftConnected() {
        return left;
    }

    public boolean isRightConnected() {
        return right;
    }

}
