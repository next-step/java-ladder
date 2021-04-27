package ladder.domain;

import ladder.rule.LineRule;

import java.util.Objects;

public class Line {
  private final boolean exist;

  private Line(boolean exist) {
    this.exist = exist;
  }

  public static Line generate(LineRule lineRule) {
    if (lineRule.isDrawing()) {
      return creat();
    }
    return empty();
  }

  public Line newNextLine(LineRule lineRule) {
    if (this.isEmpty()) {
      return generate(lineRule);
    }

    return empty();
  }

  private static Line empty() {
    return new Line(false);
  }

  private static Line creat() {
    return new Line(true);
  }

  public boolean isEmpty() {
    return !exist;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Line line = (Line) o;
    return exist == line.exist;
  }

  @Override
  public int hashCode() {
    return Objects.hash(exist);
  }

  @Override
  public String toString() {
    return "Line=" + exist;
  }
}
