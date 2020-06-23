package laddergame.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerNames {

  private final List<PlayerName> names;

  public PlayerNames(List<PlayerName> names) {
    this.names = names;
  }

  public static PlayerNames createBy(String[] names) {
    return new PlayerNames(Stream.of(names)
        .map(PlayerName::createBy)
        .collect(Collectors.toList()));
  }

  public int getCountOfNames() {
    return names.size();
  }

  public PlayerName getNameByIndex(int index) {
    return names.get(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerNames playerNames1 = (PlayerNames) o;
    return names.equals(playerNames1.names);
  }

  @Override
  public int hashCode() {
    return Objects.hash(names);
  }

  @Override
  public String toString() {
    return names.stream()
        .map(PlayerName::toString)
        .reduce("", String::concat);
  }
}
