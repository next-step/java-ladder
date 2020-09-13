package nextstep.entity;

import java.util.List;

public class LadderGame {

    private final Entries startEntries;
    private final Ladder ladder;

    private LadderGame(Entries startEntries) {
        this.startEntries = startEntries;
        this.ladder = Ladder.of();
    }

    public void initLadder(Length length) {
        Personnel personnel = Personnel.of(startEntries.getPersonnel());
        ladder.initLadder(personnel, length);
    }

    public List<List<Boolean>> getLinesStatus() {
        return ladder.getLinesStatus();
    }

    public Entry play(Entry targetEntry, Entries arrivalEntries) {
        int targetIndex = startEntries.getIndexByEntry(targetEntry);
        return arrivalEntries.getEntryByIndex(ladder.play(targetIndex));
    }

    public static LadderGame of(Entries startEntries) {
        return new LadderGame(startEntries);
    }
}
