package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class ExecuteResults {

    private static final String USER_NAME_DELIMITER = ",";
    private static final String RESULT_DELIMITER = " : ";

    private final Map<UserName, Position> userLeafPositionMap = new LinkedHashMap<>();
    private final Map<Position, Result> resultMap;

    public ExecuteResults(Map<Position, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public static ExecuteResults of(String input) {
        String[] userNames = input.split(USER_NAME_DELIMITER);
        return new ExecuteResults(
                IntStream.range(0, userNames.length)
                        .boxed()
                        .collect(collectingAndThen(
                                toUnmodifiableMap(Position::new, i -> new Result(userNames[i])),
                                LinkedHashMap::new
                        )));
    }

    public void execute(Participants participants, Ladder ladder) {
        Map<UserName, Position> leafPositionMap = participants.climb(ladder);
        userLeafPositionMap.clear();
        userLeafPositionMap.putAll(leafPositionMap);
    }

    public Result toUserResult(UserName userName) {
        Position userLeafPosition = userLeafPositionMap.get(userName);
        return resultMap.get(userLeafPosition);
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
        return resultMap.values()
                .stream()
                .map(Result::toString)
                .collect(joining(" "));
    }

}
