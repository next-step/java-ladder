package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputResults {

    private final List<InputResult> values;

    public InputResults(List<InputResult> values, String[] memberNames) {
        validateCountOfInputResults(values, memberNames);
        this.values = values;
    }

    public InputResults(String[] values, String[] memberNames) {
        this(Arrays.stream(values)
            .map(InputResult::new)
            .collect(Collectors.toUnmodifiableList()), memberNames);
    }

    public List<InputResult> values() {
        return values;
    }

    private void validateCountOfInputResults(List<InputResult> values, String[] memberNames) {
        if (values.size() != memberNames.length) {
            throw new IllegalArgumentException("실행 결과 갯수는 참여 인원수와 동일해야합니다.");
        }
    }
}
