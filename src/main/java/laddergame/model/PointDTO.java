package laddergame.model;

public class PointDTO {

  private final int position;
  private final int nextPosition;

  private PointDTO(int position, int nextPosition) {
    this.position = position;
    this.nextPosition = nextPosition;
  }

  public static PointDTO createBy(Point point) {
    return new PointDTO(point.getPosition(), point.getNextPosition());
  }

  public int getPosition() {
    return position;
  }

  public int getNextPosition() {
    return nextPosition;
  }

  public boolean hasLeft() {
    return nextPosition < position;
  }

  @Override
  public String toString() {
    return "PointDTO{" +
        "position=" + position +
        ", nextPosition=" + nextPosition +
        '}';
  }
}