package nextstep.ladder.biz;

import java.util.Collections;
import java.util.List;

public class Ladder {

  private List<LadderLine> lines;

  public Ladder(List<LadderLine> lines) {
    this.lines = lines;
  }

  public List<LadderLine> getLines() {
    return Collections.unmodifiableList(lines);
  }

  int ladderHeight() {
    return lines.size();
  }

  public Chessmen play(Chessmen chessmen) {
    int result = chessmen.getLocation();
    for (LadderLine line : lines) {
      result = line.move(result);
    }

    return chessmen.move(result);
  }

  @Override
  public String toString() {
    return "Ladder{" +
            "lines=" + lines +
            '}';
  }
}
