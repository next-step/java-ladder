package ladder.domain;

import java.util.List;

public class Participants {

    private static final int ONE = 1;
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        participantsValidation(participants);
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public int getSize() {
        return participants.size();
    }

    public int getLine() {
        return getSize() - ONE;
    }

    private void participantsValidation(List<Participant> participants) {
        if (participants.size() < 2) {
            throw new IllegalStateException("사용자는 2명이상 입력해야 합니다.");
        }
    }

    public static Participants from(List<Participant> participants) {
        return new Participants(participants);
    }
}
