package ladder.model.line;

import ladder.strategy.LadderPointsStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Points {
  private final List<Boolean> points;

  private Points(List<Boolean> points) {
    this.points = points;
  }

  public static Points makePoints(int countOfPerson, LadderPointsStrategy strategy) {
    List<Boolean> makingPoints = new ArrayList<>();
    makingPoints.add(strategy.makeFirstPoint());
    IntStream.range(1, countOfPerson - 1)
      .forEach(number -> {
        makingPoints.add(strategy.makeMiddlePoints(makingPoints.get(number - 1)));
      });
    makingPoints.add(strategy.makeLastPoint());
    return new Points(Collections.unmodifiableList(makingPoints));
  }

  public List<Boolean> specificPoints() {
    return points;
  }

}
