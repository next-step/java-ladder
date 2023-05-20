package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private static final String NOT_FOUND_POSITION_MATCH_RESULT_MESSAGE = "요청한 포지션과 매치되는 결과가 존재하지 않습니다.";

    private static final String RESULT_SEPARATOR = ",";

    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = results;
    }

    public static Results toResults(final String results, final int height) {
        return new Results(toResults(split(results), height));
    }

    private static String[] split(final String results) {
        return results.split(RESULT_SEPARATOR);
    }

    private static List<Result> toResults(final String[] resultArray, final int height) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < resultArray.length; i++) {
            results.add(new Result(resultArray[i], new Position(i, height)));
        }
        return results;
    }

    public List<String> results() {
        return results.stream()
                .map(Result::result)
                .collect(Collectors.toList());
    }

    public String reuslt(final Position position) {
        return results.stream()
                .filter(result -> result.isReach(position))
                .map(Result::result)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_POSITION_MATCH_RESULT_MESSAGE));
    }

}
