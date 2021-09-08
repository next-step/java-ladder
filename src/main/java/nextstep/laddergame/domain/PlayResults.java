package nextstep.laddergame.domain;

import java.util.List;

public class PlayResults {

    private final List<String> results;

    private PlayResults(List<String> results) {
        this.results = results;
    }

    public static PlayResults with(int requiredResultCount, List<String> results) {
        validateResultsCount(requiredResultCount, results);
        return new PlayResults(results);
    }

    private static void validateResultsCount(int requiredResultCount, List<String> results) {
        if (requiredResultCount != results.size()) {
            throw new IllegalArgumentException(String.format("실행 결과의 수가 유효하지 않습니다. required: %s, input: %s", requiredResultCount, results.size()));
        }
    }

    public List<String> getResults() {
        return results;
    }

    public String resultAt(int position) {
        return results.get(position);
    }
}
