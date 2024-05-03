package nextstep.ladder.domain.ladder;


import nextstep.ladder.domain.generator.RandomValueGenerator;

public class Cross {

    private final static int MOVE_DISTANCE_STANDARD = 1;

    private final int position;
    private final Point point;

    public Cross(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int getPosition() {
        return position;
    }

    public Point getPoint() {
        return point;
    }

    public static Cross first() {
        return new Cross(0, Point.first(new RandomValueGenerator()));
    }

    //
    public Cross next() {
        return new Cross(this.position + 1, this.point.next(new RandomValueGenerator()));
    }

    public Cross last() {
        return new Cross(this.position + 1, this.point.last());
    }

    public int move() {
        Direction direction = point.move();
        return this.position + direction.move(MOVE_DISTANCE_STANDARD);
    }


}
