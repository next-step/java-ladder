package nextstep.ladder.domain.result;

import nextstep.ladder.domain.Position;
import nextstep.ladder.util.StringSpliter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final int MIN_RESULT_COUNT = 2;

    private final List<Result> results;

    public Results(List<Result> results) {
        validateResultsCount(results);
        this.results = results;
    }

    private void validateResultsCount(List<Result> results) {
        if (results.size() < MIN_RESULT_COUNT) {
            throw new IllegalArgumentException("[ERROR] 결과는 " + MIN_RESULT_COUNT + "개 이상이어야 합니다.");
        }
    }

    public static Results from(String names) {
        List<String> resultList = StringSpliter.split(names);
        List<Result> results = resultList(resultList);
        return new Results(results);
    }

    private static List<Result> resultList(List<String> resultList) {
        List<Result> results = new LinkedList<>();
        Result result = Result.first(resultList.get(0));
        results.add(result);

        for (int index = 1; index < resultList.size(); index++) {
            result = result.next(resultList.get(index));
            results.add(result);
        }
        return results;
    }

    public Result result(Position resultPosition) {
        return results.stream()
                .filter(result -> result.equalPosition(resultPosition))
                .findFirst()
                .get();
    }

    public int size() {
        return results.size();
    }

    @Override
    public String toString() {
        return results.stream()
                .map(Result::toString)
                .collect(Collectors.joining()) + "\n";
    }
}
