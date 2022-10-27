package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.HorizontalLineDirection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLine {

    private final List<HorizontalLineDirection> horizontalLineDirections;
    private final String LADDER_LINE_START_TEXT = "    ";

    public LadderLine(List<HorizontalLineDirection> horizontalLineDirections) {
        this.horizontalLineDirections = horizontalLineDirections;
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

    @Override
    public String toString() {
        return (LADDER_LINE_START_TEXT + horizontalLineDirections.stream()
                .map(HorizontalLineDirection::toString)
                .collect(Collectors.joining()))
                .stripTrailing();
    }
}
