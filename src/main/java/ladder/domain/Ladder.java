package ladder.domain;

import ladder.rule.LineRule;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private static String ERROR_INVALID_HEIGHT_FORMAT = "사다리의 최소 높이는 %d 입니다.";
  private static String ERROR_INVALID_WIDTH_FORMAT = "사다리의 최소 폭은 %d 입니다.";
  private static int MIN_OF_HEIGHT = 1;
  private static int MIN_OF_WIDTH = 1;

  private final List<Depth> values;

  private Ladder(List<Depth> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Ladder generate(final int height, final int width) {
    checkValidHeight(height);
    checkValidWidth(width);
    return new Ladder(IntStream.range(0, height)
            .mapToObj(i -> Depth.generate(LineRule.random(), width))
            .collect(Collectors.toList()));
  }

  private static void checkValidHeight(int height) {
    if (MIN_OF_HEIGHT > height) {
      throw new IllegalArgumentException(String.format(ERROR_INVALID_HEIGHT_FORMAT, MIN_OF_HEIGHT));
    }
  }

  private static void checkValidWidth(int width) {
    if (MIN_OF_WIDTH > width) {
      throw new IllegalArgumentException(String.format(ERROR_INVALID_WIDTH_FORMAT, MIN_OF_WIDTH));
    }
  }

  public int height() {
    return this.values.size();
  }

  public int width() {
    return this.values.get(0).width();
  }

  public List<Depth> getDepth() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ladder ladder = (Ladder) o;
    return Objects.equals(values, ladder.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Ladder=" + values;
  }
}
