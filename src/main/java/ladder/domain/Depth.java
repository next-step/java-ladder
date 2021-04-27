package ladder.domain;

import ladder.exception.DepthLineOutOfBoundsException;
import ladder.rule.LineRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Depth {
  private final List<Line> values;

  private Depth(List<Line> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Depth generate(LineRule lineRule, int countOfLine) {
    checkValidLineCount(countOfLine);
    List<Line> values = new ArrayList<>(countOfLine);
    IntStream.range(0, countOfLine)
            .mapToObj(i -> Line.generate(lineRule))
            .reduce(Line.generate(lineRule), (frontLine, nextLine) -> {
              values.add(frontLine);
              return frontLine.newNextLine(lineRule);
            });
    return new Depth(values);

}

  private static void checkValidLineCount(int countOfLine) {
    DepthLineOutOfBoundsException.verify(countOfLine);
  }

  public List<Line> getValues() {
    return values;
  }

  public int width() {
    return values.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Depth lines = (Depth) o;
    return Objects.equals(values, lines.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Lines=" + values;
  }
}
