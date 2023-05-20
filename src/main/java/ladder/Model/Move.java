package ladder.Model;

import java.util.List;

public class Move {
    private static final int MIN_WIDTH = 0;

    public Move() {
    }

    public int down(LadderLine ladderLine, int index) {
        int result = index;


        if (moveLeft(ladderLine, index)) {
            return result - 1;
        }

        if (moveRight(ladderLine, index)) {
            return result + 1;
        }

        return result;
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
