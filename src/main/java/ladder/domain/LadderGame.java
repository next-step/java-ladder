package ladder.domain;

import java.util.List;

public class LadderGame {
  private final Users users;
  private final Ladder ladder;

  public LadderGame(String users, int ladderHeight) {
    this.users = new Users(users);
    this.ladder = new Ladder(this.users.countOfUser(), ladderHeight);
  }

  public List<User> users() {
    return users.unmodifiableUsers();
  }

  public List<LadderLine> ladderLines() {
    return ladder.unmodifiableLadderLines();
  }
}
