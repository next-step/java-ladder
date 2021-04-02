package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lines {

  private final List<Line> lines;

  public Lines(int height, int countOfPerson) {
    lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(new Line(countOfPerson));
    }
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

  public Stream<Line> getLines() {
    return lines.stream();
  }

  public int size() {
    return lines.size();
  }
}
