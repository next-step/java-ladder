package ladder.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Results {
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private List<Result> results;

    private Results() {
    }

    public static Results of(String inputResults, int participantsSize) {
        Results results = new Results();
        results.results = verifiedResult(inputResults, participantsSize).stream().map(Result::new).collect(toList());
        return results;
    }

    private static List<String> verifiedResult(String inputResults, int participantsSize) {
        List<String> results = Arrays.stream(inputResults.split(",")).map(String::trim).collect(toList());
        if (results.size() != participantsSize) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
        return results;
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(results.stream()
                .map(Result::toString)
                .collect(toList()));
    }
}
