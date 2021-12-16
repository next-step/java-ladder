package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private static final String MESSAGE_NOT_EQUALS_SIZE = "플레이어와 결과의 수가 일치하지 않습니다.";

    private final List<Result> results;

    public Results(String[] splitResults, int width) {
        this.results = convertTo(validationSize(splitResults, width));
    }

    private List<Result> convertTo(String[] splitResults) {
        return Arrays.stream(splitResults)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private String[] validationSize(String[] splitResults, int width) {
        if (splitResults.length != width) {
            throw new IllegalArgumentException(MESSAGE_NOT_EQUALS_SIZE);
        }
        return splitResults;
    }

    public List<Result> getResults() {
        return results;
    }
}
