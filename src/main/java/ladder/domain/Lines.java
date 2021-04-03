package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import ladder.domain.generator.Generator;
import ladder.domain.generator.PointsGenerator;

public class Lines {

  private final List<Line> lines;

  public Lines(int height, int countOfPerson) {
    lines = new ArrayList<>();
    Generator generator = new PointsGenerator(countOfPerson);
    for (int i = 0; i < height; i++) {
      lines.add(new Line(generator));
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

  public int goThroughLinesFrom(int position) {
    for (Line line : lines) {
      position = line.travel(position);
    }
    return position;
  }
}
