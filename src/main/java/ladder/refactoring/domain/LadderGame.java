package ladder.refactoring.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public static LadderGame of(String names, String height) {
        Participants participants = Participants.of(names);
        Ladder ladder = Ladder.of(participants.size(), Height.of(height));

        return new LadderGame(
                participants,
                ladder
        );
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResult play() {
        Map<Participant, Integer> result = participants.getParticipants()
                .stream()
                .collect(Collectors.toMap(participant -> participant, participant -> ladder.move(participant.position())));
        return LadderResult.of(result);
    }
}
