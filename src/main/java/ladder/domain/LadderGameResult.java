package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private final Map<User, Reward> rewardsOfUsers;

    public LadderGameResult(Map<User, Reward> rewardsOfUsers) {
        this.rewardsOfUsers = rewardsOfUsers;
    }

    public List<User> users() {
        return new ArrayList<>(rewardsOfUsers.keySet());
    }

    public Reward rewardOfUser(String user) {
        return rewardsOfUsers.get(new User(user));
    }

}
