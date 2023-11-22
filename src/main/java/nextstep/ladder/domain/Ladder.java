package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Ladder {

    private final List<Bridges> ladder;

    public Ladder(List<List<Boolean>> ladder) {
        this.ladder = ladder.stream()
            .map(Bridges::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public boolean isMovable(int xAxis, int yAxis) {
        validateIndex(yAxis);

        return ladder.get(yAxis)
            .isMovable(xAxis);
    }

    private void validateIndex(int yAxis) {
        if (yAxis < 0 || yAxis >= ladder.size()) {
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
}
