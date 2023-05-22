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
            if (moveLeft(ladderLine, integer)) {
                newIndexes.add(result - 1);
                return;
            }

            if (moveRight(ladderLine, integer)) {
                newIndexes.add(result + 1);
                return;
            }
            newIndexes.add(result);
        });

        return newIndexes;
    }

    private boolean moveLeft(LadderLine ladderLine, int index) {
        if (index == MIN_WIDTH) {
            return false;
        }

        return (index - 1 >= MIN_WIDTH && isExistHorizonLines(ladderLine.horizonLines(), index - 1));
    }

    private boolean moveRight(LadderLine ladderLine, int index) {
        int width = ladderLine.size();
        if (index == width) {
            return false;
        }

        return (index + 1 < width && isExistHorizonLines(ladderLine.horizonLines(), index));
    }

    private boolean isExistHorizonLines(List<Boolean> line, int index) {
        if (index >= line.size()) {
            return false;
        }

        return line.get(index);
    }


}
