package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

  private final List<Player> players;

  public Players(List<Player> players) {
    validateDuplicatedNames(players);
    this.players = players;
  }

  public static Players of(List<String> names) {
    return new Players(
        names.stream().map(Player::of).collect(Collectors.toList())
    );
  }

  private void validateDuplicatedNames(List<Player> values) {
    Set<String> nonDuplicatedPlayerNames = values.stream()
        .map(Player::getName)
        .collect(Collectors.toSet());
    if (nonDuplicatedPlayerNames.size() != values.size()) {
      List<String> playerNames = values.stream()
          .map(Player::getName)
          .collect(Collectors.toList());
      throw new IllegalArgumentException("플레이어 이름은 중복될 수 없습니다. " + playerNames);
    }
  }

  public int size() {
    return players.size();
  }

  public List<String> getNames() {
    return players.stream()
        .map(Player::getName)
        .collect(Collectors.toUnmodifiableList());
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
