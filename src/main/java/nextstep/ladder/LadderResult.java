package nextstep.ladder;

import java.util.Map;
import java.util.Set;

public class LadderResult {

    Map<String, String> userRewardMatchingMap;

    private LadderResult() {
    }

    private LadderResult(Map<String, String> userRewardMatchingMap) {
        this.userRewardMatchingMap = userRewardMatchingMap;
    }

    public static LadderResult of(Map<String, String> userRewarMatchingMap) {
        return new LadderResult(userRewarMatchingMap);
    }

    public String getRewardByUserName(String userName) {
        return this.userRewardMatchingMap.get(userName);
    }

    public Set<String> getUserNames() {
        return this.userRewardMatchingMap.keySet();
    }
}
