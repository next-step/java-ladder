package nextstep.ladder.domain;

public class Line {
    private static final boolean CONNECTED = true;
    private static final boolean UNCONNECTED = false;

    private boolean left = UNCONNECTED;
    private boolean right= UNCONNECTED;

    public Line(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Line() {

    }

    public void connectRight() {
        checkLeftConnected();
        right = CONNECTED;
    }

    public void connectLeft() {
        checkRightConnected();
        left = CONNECTED;
    }

    private void checkLeftConnected() {
        if(isLeftAlreadyConnected()) {
            throw new IllegalArgumentException("오른쪽으로 연결할 수 없습니다");
        }
    }

    private void checkRightConnected() {
        if(isRightAlreadyConnected()) {
            throw new IllegalArgumentException("왼쪽으로 연결할 수 없습니다");
        }
    }

    private boolean isLeftAlreadyConnected() {
        return left;
    }

    private boolean isRightAlreadyConnected() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
