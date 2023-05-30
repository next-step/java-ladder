package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantNames {

    private static final String PARTICIPANTS_SIZE_SHOULD_BE_AT_LEAST_ONE = "참가자는 최소 1명 이상이어야 합니다.";
    private final List<ParticipantName> participantNames;

    public ParticipantNames(String[] participantsInput) {
        validateParticipants(participantsInput);
        this.participantNames = convertStringArrayToList(participantsInput);
    }

    private List<ParticipantName> convertStringArrayToList(String[] participantsInput) {
        return Arrays.stream(participantsInput).map(ParticipantName::new).collect(Collectors.toList());
    }

    private void validateParticipants(String[] participantsInput) {
        if (participantsInput.length < 1) {
            throw new IllegalArgumentException(PARTICIPANTS_SIZE_SHOULD_BE_AT_LEAST_ONE);
        }
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
