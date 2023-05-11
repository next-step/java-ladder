package ladder.domain;

import java.util.List;

public class Lines {

  private final List<Line> lines;

  public Lines(List<Line> lines) {
    this.lines = lines;
  }

  public Line getRow(int rowNumber) {
    return lines.get(rowNumber);
  }

  public int height() {
    return lines.size();
  }
}
