package ladder;

import java.util.Objects;

public class Player {

  private static final String EXIT_TRIGGER = "exit";
  private static final String ALL_TRIGGER = "all";
  public static final Player ALL = Player.of(ALL_TRIGGER);
  public static final Player EXIT = Player.of(EXIT_TRIGGER);

  private final Name playerName;


  private Player(String name) {
    this(new Name(name));
  }

  Player(Name name) {
    this.playerName = name;
  }


  public static Player of(String name) {
    if (ALL_TRIGGER.equals(name)) {
      return ALL;
    }

    if (EXIT_TRIGGER.equals(name)) {
      return EXIT;
    }
    return new Player(name);
  }

  @Override
  public String toString() {
    return playerName.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return playerName.equals(player.playerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerName);
  }
}
