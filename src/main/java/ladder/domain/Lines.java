package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {

  List<Line> lines;

  public Lines(int lineNumber, int countOfPerson) {
    lines = new ArrayList<>();
    for (int i = 0; i< lineNumber; i++) {
      lines.add(new Line(countOfPerson));
    }
  }

  public Lines(List<Line> lines) {
    this.lines = lines;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lines lines1 = (Lines) o;
    return Objects.equals(lines, lines1.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lines);
  }
}
