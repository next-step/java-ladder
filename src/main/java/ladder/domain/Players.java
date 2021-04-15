package ladder.domain;

import ladder.util.StringUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
  private final List<Player> values;

  private Players(List<Player> values) {
    this.values = values;
  }

  public static Players create(String inputString) {
    List<Player> values = StringUtil.toList(inputString)
            .stream().map(Player::create)
            .collect(Collectors.toList());
    return new Players(values);
  }

  public List<Player> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Players players = (Players) o;
    return Objects.equals(values, players.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Players{" +
            "values=" + values +
            '}';
  }
}
