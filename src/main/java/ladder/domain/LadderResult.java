package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderResult {

  private final Map<User, LadderReward> rewardsOfUsers;

  public LadderResult(Map<User, LadderReward> rewardsOfUsers) {
    this.rewardsOfUsers = rewardsOfUsers;
  }

  public List<User> users() {
    return new ArrayList<>(rewardsOfUsers.keySet());
  }

  public LadderReward rewardOfUser(String user) {
    return rewardsOfUsers.get(new User(user));
  }
}
