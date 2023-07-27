package nextstep.ladder.domain;

public enum LadderBarStatus {
  EMPTY, BAR, OUT;

  public boolean isEmpty() {
    return this == EMPTY;
  }
}
