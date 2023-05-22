package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladderLines = new ArrayList<>();
    private final MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();
    private final Move move = new Move();
    private final ResultMap resultMap = new ResultMap();
    private List<Integer> currentIndexes = new ArrayList<>();

    public Ladder(List<String> attendances, int height) {
        for (int idx = 0; idx < height; idx++) {
            ladderLines.add(new LadderLine(attendances.size() - 1, makeLineStrategy));
            currentIndexes.add(idx);
        }
    }

    public List<LadderLine> ladderLines() {
        return ladderLines;
    }

    public void moveDown(List<String> attendances) {
        for (LadderLine ladderLine : ladderLines) {
            currentIndexes = move.down(ladderLine, currentIndexes);
        }

        for (int idx = 0; idx < attendances.size(); idx++){
            resultMap.put(attendances.get(idx), currentIndexes.get(idx));
        }
    }

    public ResultMap resultMap() {
        return resultMap;
    }
}
