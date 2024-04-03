package ladder.domain;

public class Player {
  private final Name name;
  private Prize prize;

  public static Player of(final String name) {
    return new Player(Name.of(name));
  }

  private Player(final Name name) {
    this.name = name;
  }

  public String name() {
    return this.name.value();
  }
}
