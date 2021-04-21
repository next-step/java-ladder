package ladder.domain;

import ladder.rule.LineRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Depth {
  private static final String ERROR_INVALID_LINE_COUNT_FORMAT = "최소 그릴 수 있는 라인 갯수(%d)가 아닙니다.";
  private static final int MIN_OF_LINE_COUNT = 1;
  
  private final List<Line> values;

  private Depth(List<Line> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Depth generate(LineRule lineRule, int countOfLine) {
    checkValidLineCount(countOfLine);
    List<Line> values = new ArrayList<>(countOfLine);
    values.add(Line.generate(lineRule));

    for (int i = 1; i < countOfLine; i++) {
      Line front = values.get(i - 1);
      values.add(front.newNextLine(lineRule));
    }
    return new Depth(values);
  }

  private static void checkValidLineCount(int countOfLine) {
    if (MIN_OF_LINE_COUNT > countOfLine) {
      throw new IllegalArgumentException(String.format(ERROR_INVALID_LINE_COUNT_FORMAT, MIN_OF_LINE_COUNT));
    }
  }

  public List<Line> getValues() {
    return values;
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
