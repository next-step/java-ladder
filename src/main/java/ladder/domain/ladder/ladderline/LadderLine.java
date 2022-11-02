package ladder.domain.ladder.ladderline;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import ladder.domain.ladder.MoveHorizontalDirection;

public class LadderLine {

    private final List<MoveHorizontalDirection> moveHorizontalDirections;

    public LadderLine(MoveHorizontalDirection... moveHorizontalDirections) {
        this(Arrays.stream(moveHorizontalDirections).collect(Collectors.toList()));
    }

    public LadderLine(List<MoveHorizontalDirection> moveHorizontalDirections) {
        this.moveHorizontalDirections = moveHorizontalDirections;
    }

    public List<MoveHorizontalDirection> horizontalLineDirections() {
        return Collections.unmodifiableList(moveHorizontalDirections);
    }

    public int width() {
        return this.moveHorizontalDirections.size();
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
        long count = IntStream.range(0, this.moveHorizontalDirections.size())
                .filter(index ->
                        !(this.moveHorizontalDirections.get(index).equals(that.moveHorizontalDirections.get(index))))
                .count();

        return count == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveHorizontalDirections);
    }
}
