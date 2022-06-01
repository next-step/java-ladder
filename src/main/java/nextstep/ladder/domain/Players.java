package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

  public static final String DELIMITER = ",";
  public static final String JOINING_DELIMITER = " ";
  private final List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
  }

  public static List<Player> create(String playerNames) {
    validateEmpty(playerNames);
    return players(playerNames);
  }

  public int count() {
    return players.size();
  }

  public int point(String playerName) {
    return players.indexOf(new Player(playerName));
  }

  private static void validateEmpty(String playerNames) {
    if (playerNames == null || playerNames.isBlank()) {
      throw new IllegalArgumentException("플레이어명은 필수입니다.");
    }
  }

  private static List<Player> players(String playerNames) {
    return Arrays.stream(playerNames.split(DELIMITER))
        .map(Player::new)
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Players players1 = (Players) o;
    return Objects.equals(players, players1.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(players);
  }

  @Override
  public String toString() {
    return players.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(JOINING_DELIMITER));
  }
}
