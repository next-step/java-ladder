package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExecuteResults {

    private static final String USER_NAME_DELIMITER = ",";
    private static final String RESULT_DELIMITER = " : ";

    private final Map<UserName, Position> userLeafPositionMap = new LinkedHashMap<>();
    private final List<Result> results;

    public ExecuteResults(List<Result> results) {
        this.results = results;
    }

    public static ExecuteResults of(String input) {
        return new ExecuteResults(
                Arrays.stream(input.split(USER_NAME_DELIMITER))
                        .map(Result::new)
                        .collect(Collectors.toUnmodifiableList()));
    }

    public void execute(Participants participants, Ladder ladder) {
        Map<UserName, Position> leafPositionMap = participants.climb(ladder);
        userLeafPositionMap.clear();
        userLeafPositionMap.putAll(leafPositionMap);
    }

    public Result toUserResult(UserName userName) {
        Position userLeafPosition = userLeafPositionMap.get(userName);
        return results.get(userLeafPosition.getCurrentPosition());
    }

    public String[] toAllResults() {
        return userLeafPositionMap.keySet()
                .stream()
                .map(this::mapToString)
                .toArray(String[]::new);
    }

    private String mapToString(UserName userName) {
        return String.join(RESULT_DELIMITER,
                userName.getName(),
                toUserResult(userName).getValue());
    }

    @Override
    public String toString() {
        return results.stream()
                .map(Result::toString)
                .collect(Collectors.joining(" "));
    }

}
