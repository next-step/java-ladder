package nextstep.ladder.biz;

import java.util.List;

public class Line {

  private final List<Boolean> points;

  public Line(int countOfPerson) {
    points = LineGenerator.form(countOfPerson);
  }

  public List<Boolean> getLine() {
    return points;
  }

  int pointOfCount() {
    return points.size();
  }

  @Override
  public String toString() {
    return "Line{" +
        "points=" + points +
        '}';
  }
}
