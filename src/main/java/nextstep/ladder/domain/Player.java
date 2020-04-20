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

  public int getPosition() {
    return position.getPosition();
  }

  public String getName() {
    return name.getName();
  }

  public void ride(Ladder ladder) {
    position = Position.at(ladder.move(position.getPosition()));
  }
}
