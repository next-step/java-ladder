package nextstep.ladder2.point;

public class LadderPoint {


    private Point left;
    private Point right;

    public LadderPoint(Point playerPoint) {
        this.left = playerPoint.left();
        this.right = checkLadderRight(playerPoint, playerPoint.MAX_INDEX());
    }

    private Point checkLadderRight(Point playerPoint, int ladderSize) {
        if (playerPoint.index() == ladderSize) {
            return Point.INVALID_POINT;
        }
        return playerPoint;
    }

    public int left() {
        return this.left.index();
    }

    public int right() {
        return this.right.index();
    }
}
