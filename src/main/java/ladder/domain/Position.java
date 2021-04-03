package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Position {

  private final int position;

  public Position(int position) {
    this.position = position;
  }

  public Position rightMove() {
    return new Position(position + 1);
  }

  public Position leftMove() {
    return new Position(position - 1);
  }

  public boolean isRightMove(List<Point> points) {
    if (position + 1 <= points.size() - 1 && points.get(position + 1).isUsed()) {
      return true;
    }
    return false;
  }

  public boolean isLeftMove(List<Point> points) {
    if (position >= 0 && points.get(position).isUsed()) {
      return true;
    }
    return false;
  }

  public int position() {
    return position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }
}
