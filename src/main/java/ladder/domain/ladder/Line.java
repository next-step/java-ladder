package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Point> points;

  private Line(List<Point> points) {
    validateNotContinuous(points);
    this.points = points;
  }

  private void validateNotContinuous(List<Point> points) {
    IntStream.range(0, points.size() - 1)
        .forEach(index -> {
          if (points.get(index).isContinuous(points.get(index + 1))) {
            throw new IllegalArgumentException("연속된 포인트가 존재합니다.");
          }
        });
  }

  Line(Point... points) {
    this(List.of(points));
  }

  public static Line createLine(int numberOfParticipants,
      NextPointGenerationStrategy generationStrategy) {
    List<Point> points = new ArrayList<>();
    Point point = Point.first(generationStrategy);
    points.add(point);

    while(point.untilBeforeLastPoint(numberOfParticipants)) {
      point = point.next(generationStrategy);
      points.add(point);
    }

    points.add(point.last());

    return new Line(points);
  }


  public List<Point> getPoints() {
    return points;
  }


  public int move(int indexOfResult) {
    return points.get(indexOfResult).move();
  }

}
