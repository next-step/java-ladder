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

  public int height() {
    return lines.size();
  }

  public int width() {
    if (lines.isEmpty()) return 0;
    return lines.get(0).width();
  }

  public Line lineAt(int index) {
    return lines.get(index);
  }
}
