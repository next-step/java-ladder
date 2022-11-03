package nextstep.step2.domain;

import java.util.List;

public class ParticipantNames {
    private final List<ParticipantName> participantNames;

    private ParticipantNames(final List<ParticipantName> participantNames) {
        this.participantNames = participantNames;
    }

    public static ParticipantNames from(final List<ParticipantName> participantNames) {
        validateParticipants(participantNames);
        return new ParticipantNames(participantNames);
    }

    private static void validateParticipants(final List<ParticipantName> participantNames) {
        if (participantNames.isEmpty()) {
            throw new IllegalArgumentException("참여자 수는 0명일 수 없습니다.");
        }
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public int count() {
        return participantNames.size();
    }
}
