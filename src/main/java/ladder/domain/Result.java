package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final static String INVALID_MESSAGE = "포함되지 않은 인원입니다.";
    private final Map<User, Reward> mapper;

    public Result(Users finalUsers, Rewards rewards) {
        mapper = new HashMap<>();

        for (int i = 0; i < finalUsers.size(); i++) {
            mapper.put(finalUsers.get(i), rewards.get(i));
        }
    }

    public String responseForOne(String input) {
        if (mapper.containsKey(new User(input))) {
            return mapper.get(new User(input)).getReward();
        }

        return INVALID_MESSAGE;
    }

    public Map<String, String> responseForAll() {
        Map<String, String> result = new HashMap<>();

        for (User user : mapper.keySet()) {
            result.put(user.getName(), mapper.get(user).getReward());
        }

        return result;
    }
}
