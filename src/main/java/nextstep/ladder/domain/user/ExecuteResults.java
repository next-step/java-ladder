package nextstep.ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteResults {

    private static final String USER_NAME_DELIMITER = ",";

    private final List<String> results;

    public ExecuteResults(List<String> results) {
        this.results = results;
    }

    public static ExecuteResults of(String input) {
        return new ExecuteResults(
                Arrays.stream(input.split(USER_NAME_DELIMITER))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public String getResult(int index) {
        return results.get(index);
    }
    
}
