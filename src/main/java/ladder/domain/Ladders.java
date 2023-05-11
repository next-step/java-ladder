package ladder.domain;

import java.util.List;

public class Ladders {

  private final Lines lines;
  private final Height height;

  public Ladders(Lines lines, Height height) {
    this.lines = lines;
    this.height = height;
  }

  public int height() {
    return height.height();
  }

  public List<Boolean> getRow(int rowNumber) {
    return lines.getRow(rowNumber).getPoints();
  }
}
