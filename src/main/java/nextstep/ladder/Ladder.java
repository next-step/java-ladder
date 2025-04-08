package nextstep.ladder;

import java.util.List;

public class Ladder {
  private final List<Line> lines;

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public List<Line> lines() {
    return lines;
  }
}
