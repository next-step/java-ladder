package nextstep.ladder.domain;

public enum LadderBarStatus {
  EMPTY, BAR;

  public boolean isEmpty() {
    return this == EMPTY;
  }
}
