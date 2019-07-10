package nextstep.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchingResult {

    Map<Integer, Integer> matchingMap;

    private MatchingResult() {
    }

    private MatchingResult(Map<Integer, Integer> matchingMap) {
        this.matchingMap = matchingMap;
    }

    public static MatchingResult of(Map<Integer, Integer> matchingMap) {
        return new MatchingResult(matchingMap);
    }

    public LadderResult map(Users users, Rewards rewards) {

        Map<String, String> userRewardMatchingMap = this.matchingMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> users.getUserByIndex(entry.getKey()).getUserName()
                        , (entry) -> rewards.getRewardByIndex(entry.getValue())
                        , (oldValue, newValue) -> oldValue
                        , LinkedHashMap::new
                        )
                );

        return LadderResult.of(userRewardMatchingMap);
    }
}
