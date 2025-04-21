package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private final List<Line> lines;

  private Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder of(int height, int countOfPerson, PointGenerateStrategy strategy) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(new Line(countOfPerson, strategy));
    }
    return new Ladder(lines);
  }

  public void printLadder() {
    lines.forEach(Line::printLine);
  }
}
