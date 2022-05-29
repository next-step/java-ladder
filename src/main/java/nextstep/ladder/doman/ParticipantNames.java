package nextstep.ladder.doman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantNames {

    private static final String NAME_DELIMITER = ",";
    private static final String NOT_NULL_PARTICIPANT_NAMES = "이름은 필수 입니다.";

    private final List<ParticipantName> participantNames;

    public ParticipantNames(String participantNames) {
        this(toParticipantNameList(participantNames));
    }

    public ParticipantNames(List<String> participantNames) {
        validate(participantNames);
        this.participantNames = toParticipantNameList(participantNames);
    }

    private static List<String> toParticipantNameList(String participantNames) {
        return Arrays.stream(participantNames.split(NAME_DELIMITER)).collect(Collectors.toList());
    }

    private void validate(List<String> participantNames) {
        if (participantNames == null || participantNames.size() <= 0) {
            throw new IllegalArgumentException(NOT_NULL_PARTICIPANT_NAMES);
        }
    }

    private List<ParticipantName> toParticipantNameList(List<String> participantNames) {
        return participantNames.stream().map(ParticipantName::new).collect(Collectors.toList());
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }
}
