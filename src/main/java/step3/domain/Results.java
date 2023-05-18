package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.view.InputView.DELIMITER;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results from(String inputResults, int countOfPlayers) {
        String[] results = inputResults.split(DELIMITER);
        validateResults(results.length, countOfPlayers);
        return new Results(Arrays.stream(results).map(Result::new).collect(Collectors.toList()));
    }

    public List<Result> getResults() {
        return results;
    }

    private static void validateResults(int length, int countOfPlayers) {
        if (length != countOfPlayers) {
            throw new IllegalArgumentException("사용자와 사용자의 실행결과 개수가 다릅니다.(사용자: " + countOfPlayers + ", 실행결과: " + length + ")");
        }
    }
}
