package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_PARTICIPANTS = 2;
    private static final String ILLEGAL_NUMBER_OF_PARTICIPANTS = "참가자 수가 유효하지 않습니다.";
    private final List<Participant> participants;

    private Participants(List<String> participantNameList) {
        this.participants = getParticipants(checkNameList(participantNameList));
    }

    public static Participants of(List<String> participantNameList) {
        return new Participants(participantNameList);
    }

    private List<Participant> getParticipants(List<String> checkedNameList) {
        return checkedNameList.stream()
            .map(Participant::of)
            .collect(Collectors.toList());
    }

    private List<String> checkNameList(List<String> participantNameList) {
        if (participantNameList.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_OF_PARTICIPANTS);
        }
        return participantNameList;
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }
}
