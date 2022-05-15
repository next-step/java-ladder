package ladder.domain.ladder;

import ladder.domain.row.Rows;

public class Ladder {
    public static final int INITIAL_HEIGHT = 0;

    private final Rows rows;

    public Ladder(Rows rows) {
        validate(rows);
        this.rows = rows;
    }

    private void validate(Rows rows) {
        if (rows == null) {
            throw new IllegalArgumentException("rows는 null 일 수 없습니다.");
        }
    }

    public static Ladder generateByWidthAndHeight(int width, int height) {
        return new Ladder(
                Rows.generateByWidthAndHeight(width, height)
        );
    }

    @Override
    public String toString() {
        return rows.toString();
    }
}
