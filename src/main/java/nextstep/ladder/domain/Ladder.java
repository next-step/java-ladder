package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MINIMUM_RAIL_COUNT = 2;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }


    public static Ladder of(int numberOfPlayer, Height height) {
        if (numberOfPlayer < MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + numberOfPlayer);
        }

        if (height == null) {
            throw new IllegalArgumentException("invalid height: cannot be null");
        }

        List<Line> lines = new ArrayList<>(height.toInt());

        for (int i = 0; i < numberOfPlayer; i++) {
            lines.add(Line.of(numberOfPlayer));
        }

        return new Ladder(lines);
    }

    public static Ladder of(int numberOfPlayer, int height) {
        return Ladder.of(numberOfPlayer, Height.of(height));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
