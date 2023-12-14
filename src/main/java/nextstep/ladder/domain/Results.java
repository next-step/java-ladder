package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Results {

    private final List<Result> values;

    public Results(List<Result> values) {
        this.values = values;
    }

    public Result getResultByPosition(int position) {
        if (position > values.size() - 1) {
            throw new IllegalArgumentException("결과 개수보다 포지션 값이 큽니다.");
        }

        return values.get(position);
    }

    public List<Result> values() {
        return Collections.unmodifiableList(values);
    }
}
