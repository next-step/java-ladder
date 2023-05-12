package ladder.domain;

import java.util.List;

public class Ladders {

  private final Lines lines;

  public Ladders(Lines lines) {
    this.lines = lines;
  }

  public int height() {
    return lines.height();
  }

  public List<Boolean> getRow(int rowNumber) {
    return lines.getRow(rowNumber).getPoints();
  }
}
