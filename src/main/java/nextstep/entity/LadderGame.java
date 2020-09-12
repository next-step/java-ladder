package nextstep.entity;

import java.util.List;

public class LadderGame {

    private final Entries startEntries;
    private final Entries arrivalEntries;
    private final Ladder ladder;

    private LadderGame(Entries startEntries, Entries arrivalEntries) {
        this.startEntries = startEntries;
        this.arrivalEntries = arrivalEntries;
        this.ladder = Ladder.of();
    }

    public void initLadder(Length length) {
        Personnel personnel = Personnel.of(startEntries.getPersonnel());
        ladder.initLadder(personnel, length);
    }

    public List<List<Boolean>> getLinesStatus() {
        return ladder.getLinesStatus();
    }

    public PlayResults play() {
        return ladder.play(startEntries, arrivalEntries);
    }

    public static LadderGame of(Entries startEntries, Entries arrivalEntries) {
        return new LadderGame(startEntries, arrivalEntries);
    }
}
