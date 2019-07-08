package ladder.impl;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

  private static final String PLAYERS_NAME_JOINING_SYMBOL = "";
  private static final String PLAYERS_NAME_DELIMITER = ",";

  private List<Player> players;

  private Players(List<Player> players) {
    this.players = players;
  }

  public static Players of(String inputName) {
    if (isBlank(inputName)) {
      throw new IllegalArgumentException("이름은 공백이면 안됨니다.");
    }
    List<Player> players = parsePlayersName(inputName);
    return new Players(players);
  }

  private static boolean isBlank(String inputName) {
    return inputName == null || "".equals(inputName.trim());
  }

  private static List<Player> parsePlayersName(String inputName) {
    return Arrays.stream(inputName.split(PLAYERS_NAME_DELIMITER))
        .map(Player::new)
        .collect(toList());
  }

  public List<Player> players() {
    return Collections.unmodifiableList(players);
  }

  public int count() {
    return players.size();
  }

  public String getName(int playerPosition) {
    return getPlayer(playerPosition).getName();
  }

  private Player getPlayer(int playerPosition) {
    return players.get(playerPosition);
  }

  @Override
  public String toString() {
    return players.stream()
        .map(Player::toString)
        .collect(Collectors.joining(PLAYERS_NAME_JOINING_SYMBOL));
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
}
