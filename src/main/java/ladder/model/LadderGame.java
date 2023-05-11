package ladder.model;

import ladder.model.ladder.Ladder;
import ladder.model.participant.Name;
import ladder.model.participant.Names;
import ladder.model.result.LadderResult;
import ladder.model.result.LadderResults;

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
        if (names.size() != ladder.countOfStiles()) {
            throw new IllegalArgumentException(
                    "The number of participants must be equal to the count of stiles in ladder"
            );
        }
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("The size of names doesn't match the size of result");
        }
    }

    public LadderResult resultOf(Name name) {
        if (!participants.contains(name)) {
            throw new IllegalArgumentException(name + "is not a participant of this game");
        }

        int startIndex = participants.indexOf(name);
        int endIndex = ladder.resultOf(startIndex);
        return results.get(endIndex);
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
