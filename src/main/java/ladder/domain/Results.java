package ladder.domain;

import ladder.exception.ResultException;

import java.util.Arrays;
import java.util.List;

public class Results {

    private static final String ERR_RESULT_SIZE = "결과 숫자를 확인해주세요.";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private final List<String> results;

    private Results(List<String> results) {
        this.results = results;
    }

    public static Results of(String text, Players players) {
        List<String> results = Arrays.asList(text.replaceAll(SPACE, EMPTY).split(DELIMITER));
        valid(results, players);
        return new Results(results);
    }

    private static void valid(List<String> results, Players players) {
        if (results.size() != players.count()) {
            throw new ResultException(ERR_RESULT_SIZE);
        }
    }

    public List<String> getResults() {
        return results;
    }
}