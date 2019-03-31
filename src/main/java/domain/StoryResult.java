package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoryResult {

    private final List<Integer> positions;

    StoryResult(List<Integer> positions) {
        this.positions = positions;
    }

    public StoryResult move(Line line) {
        List<Integer> movedPositions = new ArrayList<>();

        for (Integer position : positions) {
            movedPositions.add(line.move(position));
        }

        return new StoryResult(movedPositions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoryResult that = (StoryResult) o;
        return Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
