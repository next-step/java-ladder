package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  List<Line> lines = new ArrayList<>();

  public Ladder(int height, int countOfPerson,
      RandomPointStrategy randomPointStrategy) {
    for (int i = 0; i < height; i++) {
      lines.add(generateLines(countOfPerson, randomPointStrategy));
    }
  }

  private Line generateLines(int countOfPerson,
      RandomPointStrategy randomPointStrategy) {
    return new Line(countOfPerson, randomPointStrategy);
  }

  public void printLadder() {
    for (Line line : lines) {
      line.printLine();
    }
  }
}
