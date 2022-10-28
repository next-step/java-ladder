package ladder.domain.ladder.ladderline;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(horizontalLineDirections, that.horizontalLineDirections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalLineDirections);
    }
}
