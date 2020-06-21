package laddergame.domain.game;

import laddergame.domain.vo.Column;

import java.util.Objects;

public class Prize {
    private final String name;
    private final Column column;

    public Prize(final String resultName, final int column) {
        validateNullOrEmptyName(resultName);
        this.name = resultName.trim();
        this.column = new Column(column);
    }

    private void validateNullOrEmptyName(final String resultName) {
        if (Objects.isNull(resultName) || resultName.isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 Null 또는 공백일 수 없습니다.");
        }
    }

    public boolean isSameColumn(final int findColumn) {
        Column find = new Column(findColumn);
        return column.equals(find);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Prize)) return false;
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name) &&
                Objects.equals(column, prize.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, column);
    }
}
