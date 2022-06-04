package nextstep.ladder.domain;

public class Point {

  private final boolean left;
  private final boolean current;

  public static Point of(boolean left, boolean current) {
    return new Point(left, current);
  }

  private Point(boolean left, boolean current) {
    if (left && current) {
      throw new IllegalArgumentException("사다리 포지션은 양쪽에 동시에 존재할 수 없습니다.");
    }
    this.left = left;
    this.current = current;
  }

  public boolean current() {
    return this.current;
  }

  public Direction move() {
    if (current) {
      return Direction.RIGHT;
    } else if (left) {
      return Direction.LEFT;
    }
    return Direction.STOP;
  }

  @Override
  public String toString() {
    return "{" + "left:" + left + ", current:" + current + '}';
  }
}
