package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {
  private final Users users;
  private final Ladder ladder;

  public LadderGame(Users users, Ladder ladder) {
    this.users = users;
    this.ladder = ladder;
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

    IntStream.range(0, users.countOfUser())
            .forEach((index) -> rewardsOfUsers.put(users.userByIndex(index), ladderRewards.rewardByIndex(index)));

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
