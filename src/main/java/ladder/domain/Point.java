package ladder.domain;

public class Point {

  private final static int START_INDEX = 0;
  private final static int INCREMENT_INDEX = 1;
  private final int index;
  private final boolean current;
  private final boolean left;

  private Point(int index, boolean left, boolean current) {
    if (index == 0 && left) {
      throw new IllegalArgumentException();
    }
    this.index = index;
    this.left = left;
    this.current = current;
  }

  public static Point first(boolean current) {
    return new Point(START_INDEX, false, current);
  }

  public Point next(boolean current) {
    if (this.current) {
      return new Point(index + INCREMENT_INDEX, true, false);
    }
    return new Point(index + INCREMENT_INDEX, false, current);
  }

  public Point last() {
    return new Point(index + INCREMENT_INDEX, this.current, false);
  }

  boolean isCurrent() {
    return current;
  }

  int move() {
    if (left) {
      return index - 1;
    }
    if (current) {
      return index + 1;
    }
    return index;
  }
}
