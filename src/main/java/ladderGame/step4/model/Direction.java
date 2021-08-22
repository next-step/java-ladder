package ladderGame.step4.model;

public enum Direction {
  FORWARD(1), BACK(-1), HOLD(0);

  private final int movingPoint;

  Direction(final int point) {
    this.movingPoint = point;
  }

  public int getMovingPoint() {
    return movingPoint;
  }
}
