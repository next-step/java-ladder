package ladder;

import static ladder.Height.MESSAGE_FOR_INVALID_HEIGHT;
import static ladder.Height.MIN_HEIGHT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

  private final List<Line> ladder;

  Ladder(List<Line> ladder) {
    validateLadder(ladder);
    this.ladder = ladder;
  }

  public List<Line> lines() {
    return Collections.unmodifiableList(ladder);
  }

  private void validateLadder(List<Line> ladder) {
    if (ladder.size() < MIN_HEIGHT) {
      throw new IllegalArgumentException(String.format(MESSAGE_FOR_INVALID_HEIGHT, MIN_HEIGHT));
    }
  }

  public static Ladder from(Players players, Height height) {
    List<Line> ladder = new ArrayList<>();
    for (int i = 0; height.isMoreThan(i); i++) {
      ladder.add(i, Line.from(players));
    }
    return new Ladder(ladder);
  }
}
