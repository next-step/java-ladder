package nextstep.step2.domain;

import java.util.List;

public class ParticipantNames {

    private List<ParticipantName> participantNames;

    private ParticipantNames(List<ParticipantName> participantNames) {
        this.participantNames = participantNames;
    }

    public static ParticipantNames from(List<ParticipantName> participantNames) {
        return new ParticipantNames(participantNames);
    }
}
