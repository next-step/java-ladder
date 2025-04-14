package ladder.model;

import java.util.List;

public class LadderSession {
    private final static String ALL_USERNAME = "all";

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

    public boolean hasUserName(String name) {
        return ALL_USERNAME.equals(name) || ladderSlotsPair.hasUserName(name);
    }

    public String getGameResult(String targetName) {
        if (ALL_USERNAME.equals(targetName)) {  // 전체
            return "all\nall";  // todo: 작성
        }

        return "a";
    }
}
