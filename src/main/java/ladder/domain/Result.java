package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final static String INVALID_MESSAGE = "포함되지 않은 인원입니다.";
    private final Map<User, Reward> userRewardRelation;

    public Result(Map<User, Reward> relation) {
        this.userRewardRelation = relation;
    }

    public String responseForOne(String input) {
        return responseForOne(new User(input));
    }

    public String responseForOne(User user) {
        if (userRewardRelation != null && userRewardRelation.containsKey(user)) {
            return userRewardRelation.get(user).getReward();
        }

        return INVALID_MESSAGE;
    }

    public Map<String, String> responseForAll() {
        Map<String, String> result = new HashMap<>();

        for (User user : userRewardRelation.keySet()) {
            result.put(user.getName(), userRewardRelation.get(user).getReward());
        }

        return result;
    }
}
