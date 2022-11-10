package ladder.domain;

public class MoveByLine implements MoveStrategy {
    private final Line line;

    public MoveByLine(Line line) {
        this.line = line;
    }

    @Override
    public Point move(Point point) {
        if (line.movableToLeft(point.location())) {
            return point.frontPoint();
        }
        if (line.movableToRight(point.location())) {
            return point.behindPoint();
        }
        return point;
    }
}
