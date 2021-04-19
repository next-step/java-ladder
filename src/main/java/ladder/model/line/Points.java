package ladder.model.line;

import ladder.model.result.InterimResult;
import ladder.model.result.InterimResults;
import ladder.strategy.LadderPointsStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Points {
  private static final int UNDER_ONE = -1;
  private static final int ZERO = 0;
  private static final int ONE = 1;


  private final List<Boolean> points;

  private Points(List<Boolean> points) {
    this.points = points;
  }

  public static Points makePoints(int countOfPerson, LadderPointsStrategy strategy) {
    List<Boolean> makingPoints = new ArrayList<>();
    makingPoints.add(strategy.makeFirstPoint());
    IntStream.range(1, countOfPerson - 1)
      .forEach(number -> makingPoints.add(strategy.makeMiddlePoints(makingPoints.get(number - 1))));
    makingPoints.add(strategy.makeLastPoint());
    return new Points(Collections.unmodifiableList(makingPoints));
  }

  public List<Boolean> specificPoints() {
    return points;
  }

  public int checkMoveOrStop(int leftCursor, int currentCursor) {
    if (points.get(leftCursor)) {
      return UNDER_ONE;
    }
    if (points.get(currentCursor)) {
      return ONE;
    }

    return ZERO;
  }

  public int checkMoveOrStop(int currentCursor) {

    if (points.get(currentCursor)) {
      return ONE;
    }

    return ZERO;
  }
}
