package nextstep.ladder;

import java.util.List;

public class Ladder {
  private final List<Line> lines;

  public Ladder(List<Line> lines) {
    if (lines == null || lines.isEmpty()) {
      throw new IllegalArgumentException("Ladder는 높이가 1 이상이어야 합니다.");
    }

    this.lines = lines;
  }

  public List<Line> lines() {
    return lines;
  }

  public int height() {
    return lines.size();
  }

  public int width() {
    if (lines.isEmpty()) {
      return 0;
    }

    return lines.get(0).width();
  }

  public Line lineAt(int index) {
    return lines.get(index);
  }
}
