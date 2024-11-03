package nextstep.ladder.domain;

public class Line {
    private static final boolean CONNECTED = true;
    private static final boolean DISCONNECTED = false;

    private boolean left = DISCONNECTED;
    private boolean right = DISCONNECTED;

    public Line(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Line() {

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

    public boolean isLeftConnected() {
        return left;
    }

    public boolean isRightConnected() {
        return right;
    }

}
