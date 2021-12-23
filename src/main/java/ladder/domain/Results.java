package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<String> results;

    private Results(List<String> results) {
        this.results = results;
    }

    public static Results of(String names) {
        if (isEmpty(names)) {
            throw new IllegalArgumentException("실행결과를 입력해주세요");
        }

        String[] resultsString = names.split(",");
        List<String> results = Arrays.stream(resultsString)
                .collect(Collectors.toList());
        return new Results(results);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public int countOfResult() {
        return results.size();
    }

    public String findResultByIndex(int index) {
        return results.get(index);
    }

    public List<String> getResults() {
        return results;
    }

}
