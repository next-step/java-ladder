package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

  public static final int MIN_PLAYER_NUMBER = 2;

  private static final String MESSAGE_FOR_INVALID_NAMES = "참가자 수는 %s이상 이어야합니다.";
  private static final String NAME_DELIMITER = ",";

  private final List<Player> players;
  

  Players(List<Player> players) {
    validateNames(players);
    this.players = players;
  }

  public int playerNumber() {
    return players.size();
  }

  public List<Player> playerNames() {
    return Collections.unmodifiableList(players);
  }

  public boolean isMoreThan(int number) {
    return playerNumber() > number;
  }

  public int startIndexOf(Player player) {
    return players.indexOf(player);
  }

  public boolean has(Player player) {
    return players.contains(player);
  }

  private void validateNames(List<Player> players) {
    if (players.size() < MIN_PLAYER_NUMBER) {
      throw new IllegalArgumentException(
          String.format(MESSAGE_FOR_INVALID_NAMES, MIN_PLAYER_NUMBER)
      );
    }
  }

  public static Players of(String text) {
    return new Players(Arrays.stream(text.split(NAME_DELIMITER))
        .map(String::strip)
        .map(Player::of)
        .collect(Collectors.toUnmodifiableList()));
  }
}
