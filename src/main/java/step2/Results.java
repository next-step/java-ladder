package step2;

import java.util.*;

public class Results {

    private static final String SEPARATOR = ",";
    private static final String RESULT_MESSAGE = "참가자 수와 결과 수는 동일해야 합니다.";
    private static final String NULL_RESULT_MESSAGE = "참가자 리스트는 null일 수 없습니다.";

    private List<Result> results =  new ArrayList<>();


    public Results(List<Result> results) {
        this.results = results;
    }

    private Results(String[] str) {
        Arrays.stream(str)
                .forEach(result -> results.add(Result.newResult(result)));
    }

    public static Results newResults(String str, Players players) {
        if (str == null) {
            throw new IllegalArgumentException(NULL_RESULT_MESSAGE);
        }

        String[] split = str.trim().split(SEPARATOR);
        if (split.length != players.size()) {
            throw new IllegalArgumentException(RESULT_MESSAGE);
        }

        return new Results(split);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public int size() {
        return results.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return Objects.equals(results, results.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}