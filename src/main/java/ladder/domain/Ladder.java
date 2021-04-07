package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

  private static final int MIN_LADDER_HEIGHT = 2;
  private final List<Line> ladder;

  public Ladder(Players players, int height) {
    validateHeight(height);
    int countOfPerson = players.names().size();

    ladder = IntStream.range(0, height)
        .mapToObj(i -> new Line(countOfPerson))
        .collect(Collectors.toList());
  }

  public List<Line> lines() {
    return ladder;
  }

  private void validateHeight(int height) {
    if (height < MIN_LADDER_HEIGHT) {
      throw new IllegalArgumentException(
          "사다리의 높이는 최소 " + MIN_LADDER_HEIGHT + " 이상이여야 합니다.");
    }
  }
}
