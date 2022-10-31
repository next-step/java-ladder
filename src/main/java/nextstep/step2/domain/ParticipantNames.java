package nextstep.step2.domain;

import java.util.List;

public class ParticipantNames {

    public static final int MAX_PARTICIPANT_COUNT = 5;
    private List<ParticipantName> participantNames;

    private ParticipantNames(List<ParticipantName> participantNames) {
        this.participantNames = participantNames;
    }

    public static ParticipantNames from(List<ParticipantName> participantNames) {
        validateParticipants(participantNames);
        return new ParticipantNames(participantNames);
    }

    private static void validateParticipants(List<ParticipantName> participantNames) {
        if (participantNames.size() > MAX_PARTICIPANT_COUNT) {
            throw new IllegalArgumentException("최대 참가자 수는 5명입니다.");
        }
    }


    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public int count(){
        return participantNames.size();
    }
}
