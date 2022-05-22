package ladder;

import static ladder.Height.MESSAGE_FOR_INVALID_HEIGHT;
import static ladder.Height.MIN_HEIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

  private final List<Line> ladder;

  Ladder(List<Line> ladder) {
    validateLadder(ladder);
    this.ladder = ladder;
  }

  public List<Line> lines() {
    return ladder.stream()
        .collect(Collectors.toUnmodifiableList());
  }

  private void validateLadder(List<Line> ladder) {
    if (ladder.size() < MIN_HEIGHT) {
      throw new IllegalArgumentException(String.format(MESSAGE_FOR_INVALID_HEIGHT, MIN_HEIGHT));
    }
  }

  public static Ladder from(PlayerNumber playerNumber, Height height) {
    List<Line> ladder = new ArrayList<>();
    for (int i = 0; height.isMoreThan(i); i++) {
      ladder.add(i, Line.from(playerNumber));
    }
    return new Ladder(ladder);
  }
}
