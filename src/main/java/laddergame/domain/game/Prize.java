package laddergame.domain.game;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.PrizeName;

import java.util.Objects;

public class Prize {
    private final PrizeName prizeName;
    private final Column column;

    public Prize(final String prizeName, final int column) {
        this.prizeName = new PrizeName(prizeName.trim());
        this.column = new Column(column);
    }

    public boolean isSameColumn(final int findColumn) {
        Column find = new Column(findColumn);
        return column.equals(find);
    }

    public String getName() {
        return prizeName.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Prize)) return false;
        Prize prize = (Prize) o;
        return Objects.equals(prizeName, prize.prizeName) &&
                Objects.equals(column, prize.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName, column);
    }
}
