package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import nextstep.fp.Car;

public class Players {

  private final List<Player> players;

  public Players(List<Player> players) {
    validateSameNames(players);
    this.players = players;
  }

  public static Players of(List<String> names) {
    return new Players(
        names.stream().map(Player::of).collect(Collectors.toList())
    );
  }

  private void validateSameNames(List<Player> values) {
    Set<String> playerNameSet = values.stream()
        .map(Player::getName)
        .collect(Collectors.toSet());
    if (playerNameSet.size() != values.size()) {
      throw new IllegalArgumentException("플레이어 이름은 중복될 수 없습니다.");
    }
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
