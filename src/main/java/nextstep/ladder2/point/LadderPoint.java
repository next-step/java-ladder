package nextstep.ladder2.point;

public class LadderPoint {


    private Point left;
    private Point right;

    public LadderPoint(Point playerPoint) {
        this.left = playerPoint.left();
        this.right = playerPoint.right();
    }


}
