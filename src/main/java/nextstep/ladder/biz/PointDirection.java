package nextstep.ladder.biz;

public class PointDirection {

  private final int index;
  private final Direction direction;

  private PointDirection(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public int move() {
    if (direction.isRight()) {
      return index + 1;
    }

    if (direction.isLeft()) {
      return index - 1;
    }

    return this.index;
  }

  public boolean hasPoint() {
    return direction.isRight();
  }


  public PointDirection next() {
    return new PointDirection(index + 1, direction.next());
  }

  public PointDirection next(boolean nextRight) {
    return new PointDirection(index + 1, direction.next(nextRight));
  }

  public PointDirection last() {
    return new PointDirection(index + 1, direction.last());
  }

  public static PointDirection first(boolean right) {
    return new PointDirection(0, Direction.first(right));
  }

  @Override
  public String toString() {
    return "PointDirection{" +
            "index=" + index +
            ", direction=" + direction +
            '}';
  }
}
