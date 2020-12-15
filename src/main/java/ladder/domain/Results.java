package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private final static String INVALID_MESSAGE = "포함되지 않은 인원입니다.";

    private final Map<String, String> userRewardRelation;

    public Results(List<Result> results) {
        this.userRewardRelation = new LinkedHashMap<>();
        for (Result result : results) {
            userRewardRelation.put(result.getUser().getName(), result.getReward().getName());
        }
    }

    public String responseForOne(String input) {
        return responseForOne(new User(input));
    }

    public String responseForOne(User user) {
        if (userRewardRelation != null && userRewardRelation.containsKey(user.getName())) {
            return userRewardRelation.get(user.getName());
        }

        return INVALID_MESSAGE;
    }

    public Map<String, String> responseForAll() {
        return Collections.unmodifiableMap(userRewardRelation);
    }
}
