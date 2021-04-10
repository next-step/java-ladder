package ladder.domain;

import common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String NAME_DELIMITER = ",";

    private final List<Participant> participantList;

    public Participants(String participantNames) {
        this(generateParticipantList(participantNames));
    }

    private Participants(List<Participant> participantList) {
        this.participantList = participantList;
    }

    private static List<Participant> generateParticipantList(String participantNames) {
        validateParticipantNames(participantNames);
        return Arrays.stream(participantNames.split(NAME_DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toList())
                ;
    }

    private static void validateParticipantNames(String participantNames) {
        if (StringUtils.isBlank(participantNames)) {
            throw new IllegalArgumentException("참가자 이름을 입력해 주세요.");
        }
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public int getCount() {
        return participantList.size();
    }
}
