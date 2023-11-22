package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

    private List<Bridges> ladder;
    public Ladder(List<List<Boolean>> ladder) {
        this.ladder = ladder.stream()
            .map(Bridges::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public boolean isMovable(int xAxis, int yAxis) {
        return ladder.get(yAxis)
            .isMovable(xAxis);
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
