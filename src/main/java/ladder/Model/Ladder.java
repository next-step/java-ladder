package ladder.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ladder {
    private final List<LadderLine> ladderLines = new ArrayList<>();

    private final MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();
    private final Move move = new Move();
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
                    positionX.set(move.down(ladderLine, positionX.get()));
                }
        );

        resultMap.put(name, positionX.get());
    }

    public ResultMap resultMap() {
        return resultMap;
    }
}
