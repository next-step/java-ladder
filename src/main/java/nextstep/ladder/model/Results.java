package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {

    private static final String MESSAGE_NOT_EQUALS_SIZE = "플레이어와 결과의 수가 일치하지 않습니다.";
    private static final String MESSAGE_NOT_FOUND = "Result를 찾을 수 없습니다.";

    private final List<Result> results;

    public Results(String[] splitResults, int width) {
        this.results = convertTo(splitResults, width);
    }

    private List<Result> convertTo(String[] splitResults, int width) {
        return IntStream.range(0, validationSize(splitResults, width))
                .mapToObj(index -> new Result(splitResults[index], new Index(index)))
                .collect(Collectors.toList());
    }

    private int validationSize(String[] splitResults, int width) {
        if (splitResults.length != width) {
            throw new IllegalArgumentException(MESSAGE_NOT_EQUALS_SIZE);
        }
        return splitResults.length;
    }

    public Result findResultByIndex(Index index) {
        return results.stream().filter(result -> index.equals(result.getIndex()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_NOT_FOUND));
    }

    public List<Result> getResults() {
        return results;
    }
}
