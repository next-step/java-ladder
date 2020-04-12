package nextstep.ladder;

import nextstep.ladder.model.Name;
import nextstep.ladder.model.Position;

public class Player {
  private Name name;
  private Position position;

  public Player(String name, int position) {
    this.name = new Name(name);
    this.position = Position.at(position);
  }

  public boolean isAdjacent(Player other) {
    return this.position.isAdjacent(other.position);
  }

  public Name getName() {
    return name;
  }
}
