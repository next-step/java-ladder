package nextstep.ladder.domain;

import java.util.List;

public class Results {

    private final List<String> values;

    public Results(List<String> values) {
        this.values = values;
    }

    public String getResultByPosition(int position) {
        if (position > values.size() - 1) {
            throw new IllegalArgumentException("결과 개수보다 포지션 값이 큽니다.");
        }

        return values.get(position);
    }
}
