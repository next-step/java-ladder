package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.constant.Constant;
import ladder.util.InputValidator;

public class Ladder {

  private final List<Line> ladder = new ArrayList<>();

  public Ladder(Players players, int height) {
    validateHeight(height);
    int countOfPerson = players.names().size();

    IntStream.range(0, height)
        .forEach(i -> ladder.add(new Line(countOfPerson)));
  }

  public List<Line> lines() {
    return ladder;
  }

  private void validateHeight(int height) {
    if (InputValidator.isMinHeight(height)) {
      throw new IllegalArgumentException(
          "사다리의 높이는 최소 " + Constant.MIN_LADDER_HEIGHT + " 이상이여야 합니다.");
    }
  }
}
