package laddergame.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {

  private final List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
  }

  public static Players createByNameStrArr(String[] nameStrArr) {
    return new Players(Stream.of(nameStrArr)
        .map(s -> Player.createByNameStr(s.trim()))
        .collect(Collectors.toList()));
  }

  public PositiveNumber getCountOfPerson() {
    return new PositiveNumber(players.size());
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
    return players.equals(players1.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(players);
  }

  @Override
  public String toString() {
    return players.stream()
        .map(Player::toString)
        .reduce("", String::concat);
  }
}
