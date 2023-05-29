package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private static final int MIN_WIDTH = 0;

    public Move() {
    }

    public List<Integer> down(LadderLine ladderLine, List<Integer> oldIndexes) {
        List<Integer> newIndexes = new ArrayList<>();

        oldIndexes.forEach(integer -> {
            int result = integer;

            boolean hasLeft = isExistHorizonLines(ladderLine.horizonLines(), integer - 1);
            boolean hasRight = isExistHorizonLines(ladderLine.horizonLines(), integer);

            result += new Point(hasLeft, hasRight).move().of();

            newIndexes.add(result);
        });

        return newIndexes;
    }

    private boolean isExistHorizonLines(List<Boolean> line, int index) {
        if (index < MIN_WIDTH || index >= line.size()) {
            return false;
        }

        return line.get(index);
    }
}
