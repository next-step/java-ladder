package nextstep.step2.domain;

import java.util.List;

public class ParticipantNames {
    private final List<ParticipantName> participantNames;

    private ParticipantNames(final List<ParticipantName> participantNames) {
        this.participantNames = participantNames;
    }

    public static ParticipantNames from(final List<ParticipantName> participantNames) {
        return new ParticipantNames(participantNames);
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public int count() {
        return participantNames.size();
    }
}
