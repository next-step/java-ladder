package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {
    private static final String SIZE_EXCEPTION_MESSAGE = "결과는 하나 이상이어야 합니다.";

    private final List<Result> values;

    public Results(String ... results) {
        if (results.length == 0) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }

        this.values = Stream.of(results)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> values() {
        return Collections.unmodifiableList(values);
    }

    public int size() {
        return values.size();
    }

    public Result find(int index) {
        return values.get(index);
    }
}
