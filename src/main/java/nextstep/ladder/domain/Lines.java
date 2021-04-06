package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Lines {

  private final List<Line> lines;

  public Lines(List<Line> lines) {
    this.lines = lines;
  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
  }

  public int result(int start) {
    int position = start;
    for (Line line : lines) {
      position = line.move(position);
    }
    return position;
  }
}
