package ladder.domain;

public class Point {

  private final static Integer START_INDEX = 0;
  private final int index;
  private final boolean current;
  private final boolean left;

  private Point(final boolean current) {
    this(START_INDEX, false, current);
  }

  private Point(int index, boolean left, boolean current) {
    if (index == 0 && left) {
      throw new IllegalArgumentException();
    }
    this.index = index;
    this.left = left;
    this.current = current;
  }

  public static Point of(final boolean current) {
    return new Point(current);
  }

  public static Point of(int index, boolean left, boolean current) {
    return new Point(index, left, current);
  }

  public static Point first(boolean current) {
    return new Point(START_INDEX, false, current);
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
