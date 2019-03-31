package domain;

import java.util.ArrayList;
import java.util.List;

public class StoryResult {

    private final List<Integer> positions;

    public StoryResult(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> move(Line line) {
        List<Integer> movedPositions = new ArrayList<>();

        for (Integer position : positions) {
            movedPositions.add(line.move(position));
        }

        return movedPositions;
    }
}
