package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class Result {
    private static Map<User, Reward> result;

    public Result(Map<User, Reward> result) {
        this.result = result;
    }

    public Map<User, Reward> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public static String getIndividualResult(User userName) {
        return result.entrySet().stream()
                .filter(user -> user.getKey().equals(userName))
                .map(Map.Entry::getValue)
                .findFirst()
                .map(Reward::getReward)
                .orElseThrow(RuntimeException::new);
    }

}
