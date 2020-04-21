package nextstep.ladder.domain.model;

public class Point {
  private static final int FIRST_POINT = 0;
  private static final int STEP = 1;

  private final int index;
  private final Direction direction;

  public Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public int move() {
    if (direction.isRight()) {
      return index + STEP;
    }

    if (direction.isLeft()) {
      return index - STEP;
    }

    return this.index;
  }

  public Point next(LadderGenerationRule rule) {
    return new Point(index + STEP, direction.next(rule));
  }

  public Point next(Boolean right) {
    return new Point(index + STEP, direction.next(right));
  }

  public Point last() {
    return new Point(index + STEP, direction.last());
  }

  public static Point first(Boolean right) {
    return new Point(FIRST_POINT, Direction.first(right));
  }

  public boolean hasLeftLeg() {
    return direction.isLeft();
  }

  @Override
  public String toString() {
    return "Point{" +
        "index=" + index +
        ", direction=" + direction +
        '}';
  }
}