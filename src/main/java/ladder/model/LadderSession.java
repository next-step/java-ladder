package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderSession {

    private final LadderSlotsPair ladderSlotsPair;
    private final Ladder ladder;

    public LadderSession(LadderSlots upper, LadderSlots lower, Ladder ladder) {
        this(new LadderSlotsPair(upper, lower), ladder);
    }

    public LadderSession(LadderSlotsPair ladderSlotsPair, Ladder ladder) {
        this.ladderSlotsPair = ladderSlotsPair;
        this.ladder = ladder;
    }

    public List<String> getUserNames() {
        return ladderSlotsPair.getUserNames();
    }

    public List<String> getResultNames() {
        return ladderSlotsPair.getResultNames();
    }

    public List<LadderLine> getLadderLines() {
        return ladder.getLines();
    }


    public LadderResult runGame() {
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 0; i < ladderSlotsPair.size(); i++) {
            int resultIndex = ladder.run(i);
            result.put(i, resultIndex);
        }
        return new LadderResult(ladderSlotsPair, result);
    }

}
