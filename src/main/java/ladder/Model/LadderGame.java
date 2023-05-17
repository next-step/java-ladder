package ladder.Model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LadderGame {
    private static final int MIN_WIDTH = 0;
    private final ResultMap resultMap = new ResultMap();

    public LadderGame(List<String> attendances, Ladder ladder) {
        int width = attendances.size();
        for (int idx = 0; idx < width; idx++) {
            AtomicInteger positionX = new AtomicInteger(idx);

            ladder.ladderLines().forEach(
                    ladderLine -> {
                        positionX.set(nextX(ladderLine, positionX.get()));
                    }
            );

            resultMap.put(attendances.get(idx), positionX.get());
        }
    }

    private int nextX(LadderLine ladderLine, int index){
        int result = index;
        final int width = ladderLine.size();

        if (index - 1 >= MIN_WIDTH && isExistHorizonLines(ladderLine.horizonLines(),index - 1)) {
            return result - 1;
        }

        if (index + 1 < width && isExistHorizonLines(ladderLine.horizonLines(),index)) {
            return result + 1;
        }

        return result;
    }

    private boolean isExistHorizonLines(List<Boolean> line, int index) {
        if ( index >= line.size() ) {
            return false;
        }

        return line.get(index);
    }

    public ResultMap resultMap() {
        return resultMap;
    }
}
