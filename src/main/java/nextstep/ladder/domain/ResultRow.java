package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRow {
    private static final int MAX_LENGTH = 5;

    private final List<String> row;

    public ResultRow(List<String> results) {
        if (validateElementLength(results)) {
            throw new IllegalArgumentException("결과 중 5자리 초과인 문자가 포함되어 있습니다.");
        }
        this.row = new ArrayList<>(results);
    }

    private boolean validateElementLength(List<String> results) {
        return results.stream()
                .noneMatch(it -> it.length() <= MAX_LENGTH);
    }

    public String getResultRowAsString() {
        return row.stream()
                .map(it -> StringUtils.lPad(it, 6))
                .collect(Collectors.joining());
    }

    public String getResult(Point point) {
        return row.get(point.getValue());
    }
}
