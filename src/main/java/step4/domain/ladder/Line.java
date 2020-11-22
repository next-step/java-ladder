package step4.domain.ladder;

import step4.domain.ladder.dto.LinePointsDTO;
import step4.strategy.MakeLineStrategy;
import step4.type.DirectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static step4.type.DirectionType.*;

public class Line {
    public static final String ERROR_NOT_FOUND_DIRECTION = "진행방향을 찾을 수 없습니다. 현재 위치: x(%s), y(%s)";
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson, MakeLineStrategy strategy) {
        return new Line(strategy.create(countOfPerson));
    }

    public boolean isExistsPoint(Point targetPoint) {
        return isExistsPoint(targetPoint.getX());

    }

    public boolean isExistsPoint(int position) {
        if (isValidRangePosition(position)) {
            return false;
        }
        return Optional.of(points.get(position))
                .orElse(false);

    }

    private boolean isValidRangePosition(int position) {
        return position < 0 || position > points.size() - 1;
    }

    public LinePointsDTO getPoints() {
        return new LinePointsDTO(points);
    }

    public Point nextPosition(Point sourcePoint) {
        if (existsRight(sourcePoint)) {
            return execute(sourcePoint, asList(RIGHT, DOWN));
        }
        if (existsLeft(sourcePoint)) {
            return execute(sourcePoint, asList(LEFT, DOWN));
        }
        if (isDown(sourcePoint)) {
            return execute(sourcePoint, asList(DOWN));
        }
        String errorMsg = String.format(ERROR_NOT_FOUND_DIRECTION, sourcePoint.getX(), sourcePoint.getY());
        throw new IllegalArgumentException(errorMsg);
    }

    private boolean isDown(Point sourcePoint) {
        return !existsLeft(sourcePoint) && !existsLeft(sourcePoint);
    }

    private boolean existsLeft(Point sourcePoint) {
        return isExistsPoint(sourcePoint.getX() - 1);
    }

    private boolean existsRight(Point sourcePoint) {
        return isExistsPoint(sourcePoint.getX());
    }

    private List<DirectionType> asList(DirectionType... types) {
        return Arrays.asList(types);
    }

}
