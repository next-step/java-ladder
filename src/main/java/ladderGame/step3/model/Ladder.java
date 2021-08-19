package ladderGame.step3.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

  public static final String MSG_ERROR_LIMIT_ROUND = "라운드는 최소 1이상 입니다.";

  private static final int LIMIT_HEIGHT = 1;

  private static final int START_INDEX = 0;

  private final List<Line> lines;

  public Ladder(final List<Line> lines) {
    this.lines = Collections.unmodifiableList(lines);
  }

  public static Ladder createLadder(final int height, final int players) {
    validationHeight(height);

    return new Ladder(IntStream.range(START_INDEX, height)
        .mapToObj(i -> Line.createLine(players))
        .collect(Collectors.toList()));
  }

  private static void validationHeight(final int height) {
    if (height < LIMIT_HEIGHT) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_ROUND);
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Ladder ladder = (Ladder) o;
    return Objects.equals(lines, ladder.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lines);
  }
}
