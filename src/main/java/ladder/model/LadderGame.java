package ladder.model;

public class LadderGame {
    private final Names participants;
    private final Ladder ladder;

    public LadderGame(Names names, Ladder ladder) {
        if (names.size() != ladder.width()) {
            throw new IllegalArgumentException("the number of participants and ladder size are not same");
        }

        this.participants = names;
        this.ladder = ladder;
    }

    public Names participants() {
        return participants;
    }

    public Ladder ladder() {
        return ladder;
    }
}
