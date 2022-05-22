package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

  private static final int START_INDEX = 0;
  private static final int START_POSITIVE_INDEX = 1;
  private static final String VALIDATE_MESSAGE = "플레이어는 %d와 %d 사이에 위치해야 합니다.";

  private final List<Boolean> points = new ArrayList<>();

  public Line(List<Boolean> values) {
    this.points.addAll(values);
  }

  public static Line create(int width, BooleanGeneratingStrategy strategy) {
    List<Boolean> values = new ArrayList<>();
    values.add(false);
    for (int i = START_POSITIVE_INDEX; i < width; i++) {
      values.add(checkLineByPrevious(values.get(i - 1), strategy));
    }
    return new Line(values);
  }

  static boolean checkLineByPrevious(boolean previous, BooleanGeneratingStrategy strategy) {
    if (previous) {
      return false;
    }
    return strategy.getBoolean();
  }

  public int size() {
    return points.size();
  }

  private int lastIndex() {
    return size() - 1;
  }

  public List<Boolean> getPoints() {
    return Collections.unmodifiableList(points);
  }

  public int move(int playerIndex) {
    validateIndex(playerIndex);
    if (playerIndex == START_INDEX) {
      return moveRightOrStraight(playerIndex);
    }
    if (playerIndex == lastIndex()) {
      return moveLeftOrStraight(playerIndex);
    }

    boolean leftPoint = points.get(playerIndex);
    boolean rightPoint = points.get(playerIndex + 1);
    if (leftPoint) {
      return MoveDirection.LEFT.apply(playerIndex);
    }
    if (rightPoint) {
      return MoveDirection.RIGHT.apply(playerIndex);
    }
    return MoveDirection.STRAIGHT.apply(playerIndex);
  }

  private void validateIndex(int playerIndex) {
    if (playerIndex < START_INDEX || playerIndex > lastIndex()) {
      throw new IllegalArgumentException(
          String.format(VALIDATE_MESSAGE, START_INDEX, lastIndex())
      );
    }
  }

  private int moveRightOrStraight(int playerIndex) {
    boolean point = points.get(playerIndex + 1);
    if (point) {
      return MoveDirection.RIGHT.apply(playerIndex);
    }
    return MoveDirection.STRAIGHT.apply(playerIndex);
  }

  private int moveLeftOrStraight(int playerIndex) {
    boolean point = points.get(playerIndex);
    if (point) {
      return MoveDirection.LEFT.apply(playerIndex);
    }
    return MoveDirection.STRAIGHT.apply(playerIndex);
  }
}
