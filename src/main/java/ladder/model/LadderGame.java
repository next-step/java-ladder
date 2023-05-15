package ladder.model;

import ladder.model.ladder.Ladder;
import ladder.model.participant.Name;
import ladder.model.participant.Names;
import ladder.model.result.LadderResult;
import ladder.model.result.LadderResults;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
        if (names.count() < 2) {
            throw new IllegalArgumentException("ladder game requires at least two participants");
        }
        if (names.count() != ladder.countOfStiles()) {
            throw new IllegalArgumentException(
                    "The number of participants must be equal to the count of stiles in ladder"
            );
        }
        if (names.count() != results.size()) {
            throw new IllegalArgumentException("The count of names doesn't match the size of result");
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

    public List<LadderMatch> resultAll() {
        return participants.stream()
                .map(name -> new LadderMatch(name, resultOf(name)))
                .collect(toList());
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
