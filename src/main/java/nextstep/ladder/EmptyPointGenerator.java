package nextstep.ladder;

public class EmptyPointGenerator implements PointGenerator {

    @Override
    public Point create() {
        return new Point(PointType.EMPTY);
    }
}
