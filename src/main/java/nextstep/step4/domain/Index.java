package nextstep.step4.domain;

public class Index {
    private final int position;
    private final Point point;

    public Index(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        if(point.move() == Direction.RIGHT) {
            return position + 1;
        }
        
        if(point.move() == Direction.LEFT) {
            return position - 1;
        }
        return position;
    }
}
