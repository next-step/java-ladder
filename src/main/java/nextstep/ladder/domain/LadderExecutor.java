package nextstep.ladder.domain;

import java.util.List;

public class LadderExecutor {

    private Lines lines;
    private Participants participants;

    public LadderExecutor(Lines lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public void executeLadder() {
        for (Participant participant : participants.getParticipants()) {
            participant.move(lines);
        }
    }

    public List<Participant> getParticipants() {
        return participants.getParticipants();
    }

    public Position getParticipantFinalPosition(Participant participant) {
        return participant.getPosition();
    }

}
