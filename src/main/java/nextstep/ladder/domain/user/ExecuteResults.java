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

    private final Map<UserName, Result> userNameResultMap = new LinkedHashMap<>();
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

    public Result getResult(int index) {
        return results.get(index);
    }

    public Result getResult(UserName userName) {
        return userNameResultMap.get(userName);
    }

    public void execute(Participants participants, Ladder ladder) {
        Map<UserName, Result> result = participants.getUserNames()
                .stream()
                .collect(Collectors.toMap(
                        o -> o,
                        userName -> {
                            int userLocation = participants.userLocation(userName);
                            Position leafPosition = ladder.leafPosition(userLocation);
                            return getResult(leafPosition.getCurrentPosition());
                        }, (x, y) -> x, LinkedHashMap::new));
        userNameResultMap.putAll(result);
    }

    public String[] toArray() {
        return userNameResultMap.keySet()
                .stream()
                .map(this::mapToString)
                .toArray(String[]::new);
    }

    private String mapToString(UserName userName) {
        return String.join(RESULT_DELIMITER,
                userName.getName(),
                userNameResultMap.get(userName).getValue());
    }

    @Override
    public String toString() {
        return results.stream()
                .map(Result::toString)
                .collect(Collectors.joining(" "));
    }

}
