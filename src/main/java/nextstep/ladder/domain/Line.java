package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private List<Boolean> points = new ArrayList<>();

  public Line(int countOfPerson, PointGenerateStrategy strategy) {
    boolean previousHasLine = false;
    for (int i = 0; i < countOfPerson - 1; i++) {
      boolean current = generateNextLine(previousHasLine, strategy);
      points.add(current);
      previousHasLine = current;
    }
  }

  public boolean generateNextLine(boolean previousHasLine,
      PointGenerateStrategy strategy) {
    if (previousHasLine) {
      return false;
    }
    return strategy.generate();
  }

  public void printLine() {
    StringBuilder sb = new StringBuilder();
    for (Boolean point : points) {
      sb.append("|");
      if (point) {
        sb.append("-----");
      } else {
        sb.append("     ");
      }
    }
    sb.append("|");
    System.out.println(sb);
  }
}
