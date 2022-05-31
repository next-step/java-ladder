package nextstep.ladder.domain;

public enum Direction {
  LEFT, RIGHT, STOP;

  public boolean left() {
    return this == LEFT;
  }

  public boolean right() {
    return this == RIGHT;
  }

  public boolean stop() {
    return this == STOP;
  }
}
