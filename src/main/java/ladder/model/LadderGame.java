package ladder.model;

public class LadderGame {
    private final Names participants;
    private final Ladder ladder;

    public LadderGame(Names names, Ladder ladder) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("ladder game requires at least two participants");
        }
        if (names.size() != ladder.width() + 1) {
            throw new IllegalArgumentException(
                    "The number of participants must be greater than the width of the ladder by 1"
            );
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
