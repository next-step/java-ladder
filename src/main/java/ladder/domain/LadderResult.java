package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

public class LadderResult {
    private final List<UserResult> userResults;
    private final Map<String, UserResult> ladderResultMap;

    public LadderResult(List<UserResult> userResults) {
        this.userResults = userResults;
        this.ladderResultMap = createLadderResultMap(userResults);
    }

    private Map<String, UserResult> createLadderResultMap(List<UserResult> results) {
        return results.stream()
            .collect(
                toUnmodifiableMap(
                    UserResult::getName,
                    Function.identity()
                )
            );
    }

    public List<UserResult> getSortedResults() {
        return userResults.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public String getResult(String userName) {
        return ofNullable(ladderResultMap.get(userName))
            .map(UserResult::getResult)
            .orElseThrow(IllegalArgumentException::new);
    }
}
