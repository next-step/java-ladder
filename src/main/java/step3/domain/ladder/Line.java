package step3.domain.ladder;

import step3.domain.ladder.dto.LinePointsDTO;
import step3.strategy.MakeLineStrategy;

import java.util.List;
import java.util.Optional;

public class Line {
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
        return Optional.ofNullable(points.get(position))
                .orElse(false);

    }

    public LinePointsDTO getPoints() {
        return new LinePointsDTO(points);
    }

}
