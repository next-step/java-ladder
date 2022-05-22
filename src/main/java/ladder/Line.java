package ladder;

import static ladder.Players.MIN_PLAYER_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.RandomGenerator;

public class Line {

  private static final String MESSAGE_FOR_INVALID_POINTS = "사다리의 줄은 최소 플레이어 수보다 커야합니다.";

  private final List<Boolean> points;

  Line(List<Boolean> points) {
    validatePoints(points);
    this.points = points;
  }

  public List<Boolean> points() {
    return Collections.unmodifiableList(points);
  }

  public int playerNumber() {
    return points.size();
  }

  private void validatePoints(List<Boolean> points) {
    if (points.size() < MIN_PLAYER_NUMBER) {
      throw new IllegalArgumentException(MESSAGE_FOR_INVALID_POINTS);
    }
  }

  public static Line from(Players players) {
    List<Boolean> line = new ArrayList<>();
    for (int i = 0; players.isMoreThan(i + 1); i++) {
      seedPoint(line, i);
    }
    line.add(Boolean.FALSE);

    return new Line(line);
  }

  private static void seedPoint(List<Boolean> line, int index) {
    if (index > 0 && line.get(index - 1)) {
      line.add(index, Boolean.FALSE);
      return;
    }

    line.add(index, RandomGenerator.randomBool());
  }
}
