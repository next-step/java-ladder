package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Ladder {

    public static final String LADDER_POLE = "|";
    private static final String LINE_BREAK = "\n";

    private final List<Bridges> ladder;

    public Ladder(List<Bridges> ladder) {
        this.ladder = ladder;
    }

    public boolean isMovable(int widthPosition, int heightPosition) {
        validateIndex(heightPosition);

        return ladder.get(heightPosition)
            .isMovable(widthPosition);
    }

    private void validateIndex(int heightPosition) {
        if (heightPosition < 0 || heightPosition >= ladder.size()) {
            throw new IllegalArgumentException(OUT_OF_INDEX.message());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }

    @Override
    public String toString() {
        return ladder.stream()
            .map(this::setUpSide)
            .collect(Collectors.joining(LINE_BREAK));
    }

    private String setUpSide(Bridges bridges) {
        return LADDER_POLE + bridges.toString() + LADDER_POLE;
    }
}
