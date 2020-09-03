package nextstep.ladder.biz;

import java.util.Collections;
import java.util.List;

public class Ladder {

  private List<Line> lines;

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
  }

  int ladderHeight() {
    return lines.size();
  }

  public Chessmen play(Chessmen chessmen) {
    return lines.stream()
            .reduce(chessmen, Chessmen::cast, (c1, c2) -> c2);
  }

  @Override
  public String toString() {
    return "Ladder{" +
            "lines=" + lines +
            '}';
  }
}
