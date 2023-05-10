package nextstep.ladder.domain.user;

import nextstep.ladder.domain.formatter.Formatter;
import nextstep.ladder.domain.formatter.NameFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteResults {

    private static final String USER_NAME_DELIMITER = ",";

    private final List<String> results;
    private final Formatter formatter;

    public ExecuteResults(List<String> results) {
        this(results, new NameFormatter());
    }

    public ExecuteResults(List<String> results, Formatter formatter) {
        this.results = results;
        this.formatter = formatter;
    }

    public static ExecuteResults of(String input) {
        return new ExecuteResults(
                Arrays.stream(input.split(USER_NAME_DELIMITER))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public String getResult(int index) {
        return results.get(index);
    }

    @Override
    public String toString() {
        return results.stream()
                .map(formatter::format)
                .collect(Collectors.joining(" "));
    }

}
