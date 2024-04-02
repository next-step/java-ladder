package nextstep.step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<String> results;

    public Results(String input) {
        validation(input);
        this.results = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validation(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("결과에는 null과 공백이 올 수 없습니다.");
        }
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
