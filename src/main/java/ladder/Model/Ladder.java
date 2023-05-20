package ladder.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ladder {
    private static final int MIN_WIDTH = 0;

    private final List<LadderLine> ladderLines = new ArrayList<>();

    private final MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();
    private final ResultMap resultMap = new ResultMap();

    public Ladder(List<String> attendances, int height) {
        for (int idx = 0; idx < height; idx++) {
            ladderLines.add(new LadderLine(attendances.size() - 1, makeLineStrategy));
        }
    }

    public List<LadderLine> ladderLines() {
        return ladderLines;
    }

    public void moveDown(String name, int index) {
        AtomicInteger positionX = new AtomicInteger(index);

        ladderLines.forEach(
                ladderLine -> {
                    positionX.set(moveDownJustOnce(ladderLine, positionX.get()));
                }
        );

        resultMap.put(name, positionX.get());
    }

    private int moveDownJustOnce(LadderLine ladderLine, int index) {
        int result = index;
        final int width = ladderLine.size();

        if (index - 1 >= MIN_WIDTH && isExistHorizonLines(ladderLine.horizonLines(), index - 1)) {
            return result - 1;
        }

        if (index + 1 < width && isExistHorizonLines(ladderLine.horizonLines(), index)) {
            return result + 1;
        }

        return result;
    }

    private boolean isExistHorizonLines(List<Boolean> line, int index) {
        if (index >= line.size()) {
            return false;
        }

        return line.get(index);
    }

    public ResultMap resultMap() {
        return resultMap;
    }
}
