package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

  public static final String DELIMITER = ",";
  private final List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
  }

  public static List<Player> create(String playerNames) {
    validateEmpty(playerNames);
    return toPlayers(playerNames);
  }

  private static void validateEmpty(String playerNames) {
    if (playerNames == null || playerNames.isBlank()) {
      throw new IllegalArgumentException("플레이어명은 필수입니다.");
    }
  }

  private static List<Player> toPlayers(String playerNames) {
    return Arrays.stream(playerNames.split(DELIMITER))
        .map(Player::new)
        .collect(Collectors.toList());
  }
}
