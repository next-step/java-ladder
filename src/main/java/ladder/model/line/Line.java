package ladder.model.line;

import ladder.model.result.InterimResults;
import ladder.strategy.LadderPointsStrategy;

public class Line {
  private final Points points;

  public Line(int countOfPerson, LadderPointsStrategy strategy) {
    this.points = Points.makePoints(countOfPerson, strategy);
  }

  public InterimResults move(InterimResults interimResults) {
    return points.move(interimResults);
  }

  public Points points() {
    return points;
  }

}
