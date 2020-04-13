package nextstep.ladder.domain;

import nextstep.ladder.domain.model.Name;
import nextstep.ladder.domain.model.Position;

public class Player {
  private Name name;
  private Position position;

  public Player(String name, int position) {
    this.name = new Name(name);
    this.position = Position.at(position);
  }

  public Player(String name, Position position) {
    this.name = new Name(name);
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public boolean isAdjacent(Player other) {
    return this.position.isAdjacent(other.position);
  }

  public String getName() {
    return name.getName();
  }
}
