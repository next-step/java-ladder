package ladder;

public enum Direction {

  LEFT(-1),
  STRAIGHT(0),
  RIGHT(1);

  private static final String USER_LINE_SYMBOL = "|     ";
  private static final String HORIZONTAL_LINE_SYMBOL = "|-----";
  private int distance;

  Direction(int distance) {
    this.distance = distance;
  }

  public boolean hasLine() {
    return RIGHT == this;
  }

  public String draw() {
    return this == RIGHT ? HORIZONTAL_LINE_SYMBOL : USER_LINE_SYMBOL;
  }

  public int move(int position) {
    return position + this.distance;
  }
}