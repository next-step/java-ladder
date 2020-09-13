package nextstep.entity;

import java.util.List;

public class LadderGame {

    private final Entries startEntries;
    private final Ladder ladder;

    private LadderGame(List<String> startEntries, Length length) {
        this.startEntries = Entries.of(startEntries);
        this.ladder = Ladder.of();
        initLadder(length);
    }

    private void initLadder(Length length) {
        Personnel personnel = Personnel.of(startEntries.getPersonnel());
        ladder.initLadder(personnel, length);
    }

    public List<List<Boolean>> getLinesStatus() {
        return ladder.getLinesStatus();
    }

    public String play(String targetEntryName, List<String> arrivalEntryNames) {
        Entry targetEntry = Entry.of(targetEntryName);
        Entries arrivalEntries = Entries.of(arrivalEntryNames);

        int targetIndex = startEntries.getIndexByEntry(targetEntry);
        Entry arrivalEntry = arrivalEntries.getEntryByIndex(ladder.play(targetIndex));

        return arrivalEntry.getName();
    }

    public static LadderGame of(List<String> startEntries, Length length) {
        return new LadderGame(startEntries, length);
    }
}
