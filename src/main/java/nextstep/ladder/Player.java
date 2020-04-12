package nextstep.ladder;

import nextstep.ladder.model.Name;
import nextstep.ladder.model.Position;

public class Player {
  private Name name;
  private Position position;

  public Player(String name, int position) {

  }

  public boolean isAdjacent(Player other) {
    return false;
  }

  public Name getName() {
    return name;
  }
}
