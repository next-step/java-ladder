package ladder.model.line;

import ladder.model.result.InterimResult;
import ladder.model.result.InterimResults;
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
      .forEach(number -> makingPoints.add(strategy.makeMiddlePoints(makingPoints.get(number - 1))));
    makingPoints.add(strategy.makeLastPoint());
    return new Points(Collections.unmodifiableList(makingPoints));
  }

  public InterimResults move(InterimResults interimResults) {

    InterimResult firstInterimResult = interimResults.interimResults().stream().filter(interimResult -> interimResult.resultIndex() == 0).findFirst().get();

    interimResults
      .interimResults()
      .stream()
      .filter(interimResult -> interimResult.firstIndex() == firstInterimResult.firstIndex())
      .forEach(interimResult ->
        interimResult.move(checkMoveOrStop(false, points.get(interimResult.resultIndex())))
      );

    interimResults
      .interimResults()
      .stream()
      .filter(interimResult -> interimResult.firstIndex() != firstInterimResult.firstIndex())
      .forEach(interimResult ->
        interimResult.move(checkMoveOrStop(points.get(interimResult.resultIndex() - 1), points.get(interimResult.resultIndex())))
      );

    return interimResults;
  }

  private int checkMoveOrStop(boolean leftCursor, boolean currentCursor) {
    if (leftCursor) {
      return -1;
    }
    if (currentCursor) {
      return +1;
    }

    return 0;
  }

  public List<Boolean> specificPoints() {
    return points;
  }

}
