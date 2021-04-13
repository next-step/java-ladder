package nextstep.laddergame.domain;

import java.util.List;
import nextstep.laddergame.util.LineGenerator;

public class Line {
  private final List<Boolean> points;

  public Line(List<Boolean> points) {
    this.points = points;
  }

  public static Line createLine(int countOfPerson) {
    return new Line(LineGenerator.generate(countOfPerson));
  }

  public int size() {
    return points.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("   ");
    for (Boolean point : points) {
      if (point) {
        sb.append("|-----");
      } else {
        sb.append("|     ");
      }
    }
    sb.append("|\n");
    return sb.toString();
  }
}
