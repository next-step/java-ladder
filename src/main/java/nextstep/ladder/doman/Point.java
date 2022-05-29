package nextstep.ladder.doman;

public class Point {

    private PointDirection pointDirection;
    private boolean connected;

    public Point(PointDirection pointDirection, boolean connected) {
        this.pointDirection = pointDirection;
        this.connected = connected;
    }

    public Point(boolean connected) {
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isMove() {
        if (isHasPrevious()) {
            return false;
        }

        return this.connected;
    }

    private boolean isHasPrevious() {
        return pointDirection != null && pointDirection.isHasPrevious();
    }

    @Override
    public String toString() {
        if (isMove()) {
            return "|-----";
        }

        return "|     ";
    }
}
