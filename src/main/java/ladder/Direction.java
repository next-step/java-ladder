package ladder;

public enum Direction {

  LEFT(-1),
  STRAIGHT(0),
  RIGHT(1);

  private int distance;

  Direction(int distance) {
    this.distance = distance;
  }

  public boolean hasLine() {
    return RIGHT == this;
  }

  public int move(int position) {
    return position + this.distance;
  }
}