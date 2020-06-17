package nextstep.ladder.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(int playerCount, String[] resultArray) {
        validateResults(playerCount, resultArray);

        results = Arrays.stream(resultArray)
                    .map(Result::new)
                    .collect(Collectors.toList());
    }

    private void validateResults(int playerCount, String[] results) {
        if(playerCount != results.length) {
            throw new IllegalArgumentException("실행결과 수는 플레이어 수와 같아야 합니다.");
        }
    }

    public Result findResult(int index) {
        return results.get(index);
    }
}
