package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
  private final Users users;
  private final Ladder ladder;

  public LadderGame(Users users, int ladderHeight, LadderRewards ladderRewards) {
    this.users = users;
    this.ladder = new Ladder(this.users.countOfUser(), ladderHeight, ladderRewards);
  }

  public List<User> users() {
    return users.unmodifiableUsers();
  }

  public List<LadderLine> ladderLines() {
    return ladder.unmodifiableLadderLines();
  }

  public List<LadderReward> ladderRewards() {
    return ladder.unmodifiableLadderRewards();
  }

  public LadderResult play() {
    Map<User, LadderReward> rewardsOfUsers = new HashMap<>();

    ladderLines().forEach(this::swapUsers);

    for (int i = 0; i < users.countOfUser(); i++) {
      rewardsOfUsers.put(users.userByIndex(i), ladder.rewardByIndex(i));
    }

    return new LadderResult(rewardsOfUsers);
  }

  private void swapUsers(LadderLine ladderLine) {
    ladderLine.points().forEach(point -> {
      if (point.canMovePrevious()) {
        users.userSwap(point.currentPreviousUserPosition(), point.currentUserPosition());
      }
    });
  }
}
