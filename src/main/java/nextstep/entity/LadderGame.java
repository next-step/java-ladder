package nextstep.entity;

import java.util.List;

public class LadderGame {

    private final Entries startEntries;
    private final Ladder ladder;

    private LadderGame(Entries startEntries, Length length) {
        this.startEntries = startEntries;
        this.ladder = Ladder.of(length, Personnel.of(startEntries.getPersonnel()));
    }

    public List<List<Boolean>> getLinesStatus() {
        return ladder.getLinesStatus();
    }

    public Entry play(String targetEntryName, List<String> arrivalEntryNames) {
        Entry targetEntry = Entry.of(targetEntryName);
        Entries arrivalEntries = Entries.of(arrivalEntryNames);

        int targetIndex = startEntries.getIndexByEntry(targetEntry);
        return arrivalEntries.getEntryByIndex(ladder.play(targetIndex));
    }

    public static LadderGame of(List<String> startEntries, Length length) {
        return new LadderGame(Entries.of(startEntries), length);
    }
}
