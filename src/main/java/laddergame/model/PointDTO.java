package laddergame.model;

public class PointDTO {

  private final int position;
  private final int nextPosition;

  private PointDTO(int position, int nextPosition) {
    this.position = position;
    this.nextPosition = nextPosition;
  }

  public static PointDTO createBy(Point basicPoint) {
    return new PointDTO(basicPoint.getPosition(), basicPoint.getNextPosition());
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