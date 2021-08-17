package ladderGame.step2.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import ladderGame.step2.service.LineGenerator;

public class Line {

  private List<Boolean> points;

  public Line(final int countOfPerson) {
    this.points = Collections.unmodifiableList(LineGenerator.createLine(countOfPerson));
  }

  public List<Boolean> getPoints() {
    return points;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Line line = (Line) o;
    return Objects.equals(points, line.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }
}