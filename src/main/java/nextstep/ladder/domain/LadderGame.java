package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    public static LadderGame of(List<String> names, List<Line> lines) {
        Participants participants = Participants.of(names);
        Ladder ladder = Ladder.of(lines);
        return new LadderGame(participants, ladder);
    }

    public static LadderGame of(Participants participants, Ladder ladder) {
        return new LadderGame(participants, ladder);
    }

    private LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public int getParticipantsSize() {
        return this.participants.numberOf();
    }

    public int getLadderHeight() {
        return this.ladder.getHeight();
    }

    public Participants getParticipants() {
        return this.participants;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public List<ParticipantPosition> execute(String executeString) {
        if (executeString.equals("all")) {
            return participants.get().stream()
                    .map((participant) -> ParticipantPosition.of(participant, move(participant)))
                    .collect(Collectors.toUnmodifiableList());
        }

        Participant participant = Participant.of(executeString);
        ParticipantPosition position = ParticipantPosition.of(participant, move(participant));
        return List.of(position);
    }

    private int move(Participant participant) {
        int position = participants.startPosition(participant);
        return ladder.move(position);
    }

}
