package ladder.domain.participant;

import ladder.exception.InsufficientParticipantsCountException;

import java.util.List;

public class Participants {

    private static final int MIN_PARTICIPANTS_COUNT = 2;
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        if(participants.size() < MIN_PARTICIPANTS_COUNT) {
            throw new InsufficientParticipantsCountException();
        }
        this.participants = participants;
    }

    public int participantCount() {
        return participants.size();
    }

    @Override
    public String toString() {
        return participants.toString();
    }
}
