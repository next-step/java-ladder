package nextstep.ladder.domain;

import java.util.List;

public class Lines {

  private final List<Line> lines;

  public Lines(List<Line> lines) {
    this.lines = lines;
  }

  public int move(int startPoint) {
    int result = startPoint;
    for (Line line : lines) {
      result = line.move(result);
    }
    return result;
  }

}
