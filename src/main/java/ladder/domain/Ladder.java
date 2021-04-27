package ladder.domain;

import ladder.exception.LadderHeightOutOfBoundsException;
import ladder.exception.LadderWidthOutOfBoundsException;
import ladder.rule.LineRule;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private final List<Depth> values;

  private Ladder(List<Depth> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Ladder generate(final int height, final int width) {
    LadderHeightOutOfBoundsException.verify(height);
    LadderWidthOutOfBoundsException.verify(width);
    return new Ladder(IntStream.range(0, height)
            .mapToObj(i -> Depth.generate(LineRule.random(), width))
            .collect(Collectors.toList()));
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
