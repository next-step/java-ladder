package nextstep.ladder.domain;

import nextstep.ladder.domain.model.Name;
import nextstep.ladder.domain.model.Prize;

public class Player {
  private Name name;
  private int position;

  public Player(String name, int position) {
    this.name = new Name(name);
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name.getName();
  }

  public void ride(Ladder ladder) {

  }

  public Prize checkPrize(PrizeSheet prizeSheet) {
    return null;
  }
}
