package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.ladder.engine.dto.LineDto;

import java.util.Arrays;
import java.util.List;

public class LadderLine implements Line {

    private static final int MINIMUM_POINTS = 2;

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(Point... points) {
        return LadderLine.of(Arrays.asList(points));
    }

    public static LadderLine of(List<Point> points) {
        validate(points);
        return new LadderLine(points);
    }

    private static void validate(List<Point> points) {
        if (points.size() < MINIMUM_POINTS) {
            throw new IllegalArgumentException("두 개 이상의 지점이 있어야 합니다.");
        }
    }

    @Override
    public Position move(Position position) {
        return points.get(position.getIndex()).traverse();
    }

    @Override
    public int getWidth() {
        return points.size();
    }

    @Override
    public boolean isConnectedToRight(Position position) {
        if (position.getIndex() == getWidth() - 1) {
            return false;
        }
        
        Point point = points.get(position.getIndex());
        Position neighborPosition = point.traverse();

        return position.getRight().equals(neighborPosition);
    }

    @Override
    public LineDto export() {
        return LineDto.of(this);
    }
}
