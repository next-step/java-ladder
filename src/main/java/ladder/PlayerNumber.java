package ladder;

import java.util.Objects;

public class PlayerNumber {

  public static final int MIN_PLAYER_NUMBER = 2;

  private static final String MESSAGE_FOR_INVALID_PLAYER_NUMBER = "잘못된 플레이어 수입니다.";

  private final int playerNumber;

  PlayerNumber(int playerNumber) {
    validatePlayerNumber(playerNumber);
    this.playerNumber = playerNumber;
  }

  public boolean isMoreThan(int number) {
    return playerNumber > number;
  }

  private void validatePlayerNumber(int playerNumber) {
    if (playerNumber < MIN_PLAYER_NUMBER) {
      throw new IllegalArgumentException(MESSAGE_FOR_INVALID_PLAYER_NUMBER);
    }
  }

  public static PlayerNumber from(PlayerNames playerNames) {
    return new PlayerNumber(playerNames.playerNumber());
  }

  public static PlayerNumber from(Line line) {
    return new PlayerNumber(line.playerNumber());
  }
}
