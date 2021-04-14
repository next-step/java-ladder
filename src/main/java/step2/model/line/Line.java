package step2.model.line;

import step2.strategy.LadderPointsStrategy;

public class Line {
  private final Points points;

  public Line(int countOfPerson, LadderPointsStrategy strategy) {
    this.points = Points.makePoints(countOfPerson, strategy);
  }

  public Points points() {
    return points;
  }

}