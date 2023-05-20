package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;

public class PlayerName {
  private static final int MAX_NAME_LENGTH = 5;

  private String name;

  public PlayerName(String name) {
    throwIfHasInvalidName(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void throwIfHasInvalidName(String name) {
    if(name.length() > MAX_NAME_LENGTH) {
      throw new LadderGameException(ExceptionCode.EXCEED_PLAYER_NAME_LENGTH);
    }
  }
}
