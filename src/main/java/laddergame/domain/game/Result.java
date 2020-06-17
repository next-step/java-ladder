package laddergame.domain.game;

import laddergame.domain.vo.Column;

import java.util.Objects;

public class Result {
    private final String name;
    private final Column column;

    public Result(final String resultName, final int column) {
        validateNullOrEmptyName(resultName);
        this.name = resultName;
        this.column = new Column(column);
    }

    private void validateNullOrEmptyName(final String resultName) {
        if (Objects.isNull(resultName) || resultName.isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 Null 또는 공백일 수 없습니다.");
        }
    }
}
