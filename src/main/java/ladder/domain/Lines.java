package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Lines {

  private List<Line> lines;

  private Lines(List<Line> lines) {
    this.lines = Collections.unmodifiableList(lines);
  }

  public static Lines of(List<Line> lines) {
    return new Lines(lines);
  }

  public List<Line> getLines() {
    return lines;
  }
}
