package laddergame.model;

public class PointDTO {

  private final Position position;
  private final Position nextPosition;

  private PointDTO(Position position, Position nextPosition) {
    this.position = position;
    this.nextPosition = nextPosition;
  }

  public static PointDTO createBy(Point basicPoint) {
    return new PointDTO(basicPoint.getPosition(), basicPoint.getNextPosition());
  }

  public boolean hasLeft() {
    return nextPosition.getValue() < position.getValue();
  }

  @Override
  public String toString() {
    return "PointDTO{" +
        "position=" + position +
        ", nextPosition=" + nextPosition +
        '}';
  }
}