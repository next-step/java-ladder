package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
  private final Users users;
  private final Ladder ladder;

  public LadderGame(Users users, int ladderHeight) {
    this.users = users;
    this.ladder = new Ladder(this.users.countOfUser(), ladderHeight);
  }

  public List<User> users() {
    return users.unmodifiableUsers();
  }

  public List<LadderLine> ladderLines() {
    return ladder.unmodifiableLadderLines();
  }

  public LadderResult play(LadderRewards ladderRewards) {
    Map<User, LadderReward> rewardsOfUsers = new HashMap<>();

    ladderLines().forEach(this::iterateLines);

    for (int i = 0; i < users.countOfUser(); i++) {
      rewardsOfUsers.put(users.userByIndex(i), ladderRewards.rewardByIndex(i));
    }

    return new LadderResult(rewardsOfUsers);
  }

  private void iterateLines(LadderLine ladderLine) {
    ladderLine.points().forEach(this::swapUsers);
  }

  private void swapUsers(Point point) {
    if (point.canMovePrevious()) {
      users.userSwap(point.currentPreviousUserPosition(), point.currentUserPosition());
    }
  }
}
