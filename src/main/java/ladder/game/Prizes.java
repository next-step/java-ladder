package ladder.game;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Prizes {
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private final List<Prize> prizes;

    public Prizes(String inputResults, int participantsSize) {
        this.prizes = verifiedResult(inputResults, participantsSize).stream().map(Prize::new).collect(toList());
    }

    private static List<String> verifiedResult(String inputResults, int participantsSize) {
        List<String> results = Arrays.stream(inputResults.split(","))
                .map(String::trim).collect(toList());
        if (results.size() != participantsSize) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
        return results;
    }

    public String getPrize(int index) {
        return prizes.get(index).toString();
    }

    public int getSize() {
        return prizes.size();
    }
}
