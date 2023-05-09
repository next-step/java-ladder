package ladder.model;

public class LadderGame {
    private final Names participants;
    private final Ladder ladder;
    private final LadderResults results;

    public LadderGame(Names names, Ladder ladder, LadderResults results) {
        validate(names, ladder, results);

        this.participants = names;
        this.ladder = ladder;
        this.results = results;
    }

    private static void validate(Names names, Ladder ladder, LadderResults results) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("ladder game requires at least two participants");
        }
        if (names.size() != ladder.width() + 1) {
            throw new IllegalArgumentException(
                    "The number of participants must be greater than the width of the ladder by 1"
            );
        }
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("The size of names doesn't match the size of result");
        }
    }

    public Names participants() {
        return participants;
    }

    public Ladder ladder() {
        return ladder;
    }

    public LadderResults results() {
        return results;
    }
}
