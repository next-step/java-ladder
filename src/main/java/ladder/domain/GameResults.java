package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {

    private final List<GameResult> values;

    public GameResults(List<GameResult> values, String[] memberNames) {
        validateCountOfInputResults(values, memberNames);
        this.values = values;
    }

    public GameResults(String[] values, String[] memberNames) {
        this(Arrays.stream(values)
            .map(GameResult::new)
            .collect(Collectors.toUnmodifiableList()), memberNames);
    }

    public List<GameResult> values() {
        return values;
    }

    private void validateCountOfInputResults(List<GameResult> values, String[] memberNames) {
        if (values.size() != memberNames.length) {
            throw new IllegalArgumentException("실행 결과 갯수는 참여 인원수와 동일해야합니다.");
        }
    }
}
