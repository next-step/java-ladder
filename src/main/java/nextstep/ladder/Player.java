package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;

import java.util.Objects;

public class Player {
  private final String name;
  private final int location;

  public Player(String name, int location) {
    this.name = name;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public int getLocation() {
    return location;
  }

  public Chessmen asChessmen() {
    return Chessmen.of(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return location == player.location &&
            Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, location);
  }

  @Override
  public String toString() {
    return "Player{" +
            "name='" + name + '\'' +
            ", location=" + location +
            '}';
  }

  public boolean match(String playName) {
    return name.equals(playName);
  }
}
