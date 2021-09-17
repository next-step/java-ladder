package nextstep.ladder2.point;

import nextstep.ladder2.player.Direction;

import java.util.List;

public class LadderPoint {


    private Point left;
    private Point right;
    private Point current;

    public LadderPoint(Point playerPoint) {
        this.current = playerPoint;
        this.left = playerPoint.left();
        this.right = checkLadderRight(playerPoint, playerPoint.MAX_INDEX()-1);
    }

    private Point checkLadderRight(Point playerPoint, int ladderSize) {
        if (playerPoint.index() == ladderSize) {
            return Point.INVALID_POINT;
        }
        return playerPoint;
    }

    public Point left() {
        return this.left;
    }

    public Point right() {
        return this.right;
    }

    public Point current(){
        return this.current;
    }

    public Direction chooseDirection(List<Boolean> ladderLine){
        int currentPosition = current().index();
        if (left() != Point.INVALID_POINT && ladderLine.get(left().index())) {
            return Direction.LEFT;
        }
        if (right() != Point.INVALID_POINT && ladderLine.get(right().index())) {
            return Direction.RIGHT;
        }
        return Direction.STAY;
    }
}
