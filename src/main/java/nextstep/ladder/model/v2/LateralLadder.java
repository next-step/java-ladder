package nextstep.ladder.model.v2;

import nextstep.ladder.model.api.Ladder;

import java.util.List;

public class LateralLadder implements Ladder {
    public static final int START_HEIGHT = 0;

    private final List<LadderLine> lines;

    public LateralLadder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public LadderLine getLine(int index) {
        return lines.get(index);
    }

    @Override
    public int climb(int width) {
        int currentWidth = width;

        for (int currentHeight = START_HEIGHT; currentHeight < height(); currentHeight++) {
            currentWidth = lines.get(currentHeight).move(currentWidth);
        }

        return currentWidth;
    }

    @Override
    public int height() {
        return lines.size();
    }
}
