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

  public Integer moveTo(final Ladder ladder) {
    Integer position = this.initialPosition;

    for (Row row : ladder) {
      position = row.nextPosition(position);
    }

    return position;
  }
}
