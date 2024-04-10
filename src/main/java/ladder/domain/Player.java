package ladder.domain;

public class Player {
  private final Name name;
  private final Integer initialPosition;

  public static Player of(final String name, final Integer initialPosition) {
    return new Player(Name.of(name), initialPosition);
  }

  private Player(final Name name, Integer initialPosition) {
    this.name = name;
    this.initialPosition = initialPosition;
  }

  public String name() {
    return this.name.value();
  }

  public Coordinates move(final Ladder ladder) {
    Coordinates position = Coordinates.of(this.initialPosition, 0);

    for (Row row : ladder) {
      position = row.nextPosition(position);
    }

    return position;
  }
}
