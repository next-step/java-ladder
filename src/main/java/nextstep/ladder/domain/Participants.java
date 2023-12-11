package nextstep.ladder.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {
    private static final String PARTICIPANTS_BLANK_ERROR = "참가자를 입력해주세요.";
    private static final String PARTICIPATNS_MINIMUM_ERROR = "참가자가 부족합니다.";

    private final List<Participant> participants;

    public Participants(String participants) {
        this.participants = new ArrayList<>();
        isNullParticipants(participants);
        for (String participant : convertList(splitParticipants(participants))) {
            this.participants.add(new Participant(participant));
        }
    }

    private void isNullParticipants(String participants) {
        if (StringUtils.isBlank(participants)) {
            throw new IllegalArgumentException(PARTICIPANTS_BLANK_ERROR);
        }
    }

    private String[] splitParticipants(String participants) {
        String[] participantArray = participants.split(",");
        if (participantArray.length < 2) {
            throw new IllegalArgumentException(PARTICIPATNS_MINIMUM_ERROR);
        }
        return participantArray;
    }

    private List<String> convertList(String[] participants) {
        return Arrays.asList(participants);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }
}
