package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantNames {

    private static final int ZERO_SIZE = 0;
    private static final int MINIMUM_PARTICIPANTS_SIZE = 1;
    private final List<ParticipantName> participantNames;

    public ParticipantNames(List<String> participantsInput) {
        validateParticipants(participantsInput);
        this.participantNames = convertStringListToParticipantNameList(participantsInput);
    }

    private List<ParticipantName> convertStringListToParticipantNameList(List<String> participantsInput) {
        return participantsInput.stream()
                .map(ParticipantName::new)
                .collect(Collectors.toList());
    }

    private void validateParticipants(List<String> participantsInput) {
        if (participantsInput.size() < MINIMUM_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(sendExceptionMessageForParticipants());
        }
    }

    private String sendExceptionMessageForParticipants() {
        return String.format("참가자는 최소 1명 이상이어야 합니다. participantsInputSize : %d", ZERO_SIZE);
    }

    public int getParticipantsSize() {
        return participantNames.size();
    }

    public int getIndex(ParticipantName participantName) {
        return participantNames.indexOf(participantName);
    }

    public List<ParticipantName> getParticipantNamesAsList() {
        return participantNames;
    }
}
