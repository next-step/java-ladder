package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteResult {
    private static final String SPLIT_COMMA = ",";

    private final List<String> results;

    public ExecuteResult(final int countOfPerson, final String result) {
        this(fromResult(result));
        validateSameSizeResultPerson(countOfPerson);
    }

    public ExecuteResult(List<String> results) {
        this.results = new ArrayList<>(results);
    }

    public static List<String> fromResult(String result) {
        List<String> results = new ArrayList<>();

        String[] resultArray = result.split(SPLIT_COMMA);
        results.addAll(Arrays.asList(resultArray));

        return results;
    }

    private void validateSameSizeResultPerson(int countOfPerson) {
        if (countOfPerson != size()) {
            throw new IllegalArgumentException("참여자 수 만큼 결과를 입력해주세요.");
        }
    }

    public int size() {
        return results.size();
    }

    public List<String> getResults() {
        return results;
    }

    public String getResultsWithPosition(Position position) {
        return results.get(position.getX());
    }
}
