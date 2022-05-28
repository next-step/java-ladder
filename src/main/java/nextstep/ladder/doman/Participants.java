package nextstep.ladder.doman;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final String NOT_NULL_PARTICIPANT_NAMES = "참가자 이름은 필수 입니다.";

    private final List<Participant> participants;

    public Participants(ParticipantNames participantNames) {
        this(participantNames.getParticipantNames());
    }

    public Participants(List<ParticipantName> participantNames) {
        validate(participantNames);
        this.participants = makeParticipants(participantNames);
    }

    private void validate(List<ParticipantName> participantNames) {
        if (participantNames == null || participantNames.size() <= 0) {
            throw new IllegalArgumentException(NOT_NULL_PARTICIPANT_NAMES);
        }
    }

    private List<Participant> makeParticipants(List<ParticipantName> participantNames) {
        return participantNames.stream().map(Participant::new).collect(Collectors.toList());
    }

    public int getParticipantCount() {
        return participants.size();
    }

    @Override
    public String toString() {
        return participants.stream().map(Participant::toString).collect(Collectors.joining(""));
    }
}
