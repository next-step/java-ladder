package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Results {
    private final static String DELIMITER = ",";
    private final List<Result> results;

    public Results(String inputResults) {
        this(convertList(split(inputResults)));

    }

    public Results(List<Result> results) {
        this.results = results;
    }

    private static List<Result> convertList(String[] results) {
        return Arrays.stream(results)
                .map(String::trim)
                .map(Result::new)
                .toList();
    }

    private static String[] split(String players) {
        return players.split(DELIMITER);
    }

    public List<Result> getResults() {
        return this.results;
    }

    public Result findResultByIndex(int index) {
        return this.results.get(index);
    }
}
