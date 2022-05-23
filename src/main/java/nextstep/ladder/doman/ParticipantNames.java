package nextstep.ladder.doman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantNames {

    private static final String NAME_DELIMITER = ",";

    private final List<ParticipantName> participantNames;

    public ParticipantNames(String participantNames) {
        this(toParticipantNameList(participantNames));
    }

    public ParticipantNames(List<String> participantNames) {
        this.participantNames = toParticipantNameList(participantNames);
    }

    private static List<String> toParticipantNameList(String participantNames) {
        return Arrays.stream(participantNames.split(NAME_DELIMITER)).collect(Collectors.toList());
    }

    private List<ParticipantName> toParticipantNameList(List<String> participantNames) {
        return participantNames.stream().map(ParticipantName::new).collect(Collectors.toList());
    }
}
