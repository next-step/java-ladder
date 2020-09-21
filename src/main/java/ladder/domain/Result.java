package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Result {
    private static Map<User, Reward> result = new HashMap<>();

    public Result(User user, Reward reward) {
        this.result.put(user, reward);
    }

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
                .orElseThrow(() -> new IllegalArgumentException("해당 유저의 이름으로 결과를 찾을 수 없습니다."));
    }

}
