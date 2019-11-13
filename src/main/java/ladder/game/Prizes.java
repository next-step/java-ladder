package ladder.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Prizes {
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private List<Prize> prizes;

    private Prizes() {
    }

    public static Prizes of(String inputResults, int participantsSize) {
        Prizes prizes = new Prizes();
        prizes.prizes = verifiedResult(inputResults, participantsSize).stream().map(Prize::new).collect(toList());
        return prizes;
    }

    private static List<String> verifiedResult(String inputResults, int participantsSize) {
        List<String> results = Arrays.stream(inputResults.split(",")).map(String::trim).collect(toList());
        if (results.size() != participantsSize) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
        return results;
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(prizes.stream()
                .map(Prize::toString)
                .collect(toList()));
    }
}
