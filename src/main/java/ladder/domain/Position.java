package ladder.domain;

import java.util.List;

public class Position {

  private final int position;

  public Position(int position) {
    this.position = position;
  }

  public Position rightMove() {
    return new Position(position + 1);
  }

  public Position leftMove() {
    return new Position(position -1);
  }

  public boolean isRightMove(List<Point> points) {
    if (position + 1 <= points.size() - 1 && points.get(position + 1).isUsed() ) {
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
}
