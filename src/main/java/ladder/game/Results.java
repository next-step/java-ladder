package ladder.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Results {
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private static final String RESULT_LENGTH_EXCEPTION = "사다리게림의 결과는 5자를 넘을 수 없습니다";

    private List<Result> results;

    private Results() {}

    public static Results of(String inputResults, int participantsSize) {
        Results results = new Results();
        List<String> tempResults = Arrays.stream(inputResults.split(",")).map(String :: trim).collect(toList());
        if ( tempResults.size() != participantsSize ) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
        if ( tempResults.stream().anyMatch(tempResult -> tempResult.length() > 5) ) {
            throw new IllegalArgumentException(RESULT_LENGTH_EXCEPTION);
        }
        results.results = tempResults.stream().map(Result::new).collect(toList());

        return results;
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(results.stream().map(Result :: toString).collect(toList()));
    }
}
