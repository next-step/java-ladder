package nextstep.ladder.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Position {

  private static final Map<Integer, Position> positions = new HashMap<>();

  private int position;

  private Position(int position) {
    throwIfInvalid(position);

    this.position = position;
  }

  private void throwIfInvalid(int position) {
    if (position < 0) {
      throw new IllegalArgumentException("위치는 0보다 작을 수 업습니다.");
    }
  }

  public static Position at(int position) {
    return positions.computeIfAbsent(position, Position::new);
  }

  public boolean isAdjacent(Position other) {
    int distance = this.position - other.position;

    return distance == 1 || distance == -1;
  }

  public boolean isFirst() {
    return position == 0;
  }

  public Position getLeft() {
    return Position.at(this.position - 1);
  }
}
