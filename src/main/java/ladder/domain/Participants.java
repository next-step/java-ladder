package ladder.domain;

import java.util.List;

public class Participants {

    private static final int MINIMUM_PARTICIPANT_COUNT = 2;
    private final List<Participant> participants;

    public static Participants from(List<Participant> participants) {
        return new Participants(participants);
    }

    private Participants(List<Participant> participants) {
        participantsValidation(participants);
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public int getSize() {
        return participants.size();
    }


    private void participantsValidation(List<Participant> participants) {
        if (participants.size() < MINIMUM_PARTICIPANT_COUNT) {
            throw new IllegalStateException("사용자는 2명이상 입력해야 합니다.");
        }
    }

}
