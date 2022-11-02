package ladder.domain.ladder.ladderline;

import java.util.stream.IntStream;
import ladder.domain.ladder.HorizontalLineDirection;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<HorizontalLineDirection> horizontalLineDirections;

    public LadderLine(List<HorizontalLineDirection> horizontalLineDirections) {
        this.horizontalLineDirections = horizontalLineDirections;
    }

    public List<HorizontalLineDirection> horizontalLineDirections() {
        return Collections.unmodifiableList(horizontalLineDirections);
    }

    public int width() {
        return this.horizontalLineDirections.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderLine that = (LadderLine) o;
        long count = IntStream.range(0, this.horizontalLineDirections.size())
                .filter(index -> (this.horizontalLineDirections.get(index) != that.horizontalLineDirections.get(index)))
                .count();

        return count == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalLineDirections);
    }
}
