package ladder.domain.ladder;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<HorizontalLineDirection> horizontalLineDirections;

    public LadderLine(HorizontalLineDirection... horizontalLineDirections) {
        this(Arrays.stream(horizontalLineDirections).collect(Collectors.toList()));
    }

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
        return isEqualLadderLine(that);
    }

    private boolean isEqualLadderLine(LadderLine that) {
        long count = IntStream.range(0, this.horizontalLineDirections.size())
                .filter(index -> isNotEqualMoveHorizontalDirection(that, index))
                .count();

        return count == 0;
    }

    private boolean isNotEqualMoveHorizontalDirection(LadderLine that, int index) {
        return !(this.horizontalLineDirections.get(index).equals(that.horizontalLineDirections.get(index)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalLineDirections);
    }
}
