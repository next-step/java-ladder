package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    public static final String SEPARATOR = ",";

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results valueOf(String enteredResults, int countOfPerson) {
        List<Result> results = Arrays.stream(enteredResults.split(SEPARATOR))
                .map(Result::of)
                .collect(Collectors.toList());

        checkResultSize(results, countOfPerson);
        return new Results(results);
    }

    private static void checkResultSize(List<Result> results, int countOfPerson) {
        if (results.size() != countOfPerson) {
            throw new IllegalArgumentException("게임 결과 수와 참가자 수가 일치하지 않습니다.");
        }
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public Result find(int finalPoint) {
        return results.get(finalPoint);
    }
}
