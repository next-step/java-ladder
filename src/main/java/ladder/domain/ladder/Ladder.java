package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import ladder.domain.ladder.line.Line;

public class Ladder {

  private final List<Line> lines;

  public Ladder(List<Line> ladderLines) {
    this.lines = Collections.unmodifiableList(ladderLines);
  }

  public List<Line> getLines() {
    return lines;
  }

  public int getLineSize() {
    return lines.size();
  }
}
