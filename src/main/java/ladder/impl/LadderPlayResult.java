package ladder.impl;

import ladder.PlayResult;

public class LadderPlayResult implements PlayResult {

  private int playerPosition;
  private int targetPosition;

  public LadderPlayResult(int playerPosition, int targetPosition) {
    this.playerPosition = playerPosition;
    this.targetPosition = targetPosition;
  }

  public static LadderPlayResult of(int playerPosition, int targetPosition) {
    return new LadderPlayResult(playerPosition, targetPosition);
  }

  public int playerPosition() {
    return playerPosition;
  }

  public int targetPosition() {
    return targetPosition;
  }
}
