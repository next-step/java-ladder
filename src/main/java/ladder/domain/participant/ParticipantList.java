package ladder.domain.participant;

import ladder.constants.Constants;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantList {

    private List<Participant> participants;

    public ParticipantList(String participantString) {
        this.participants = participants(participantString);
    }

    private List<Participant> participants(String participantString) {
        return Arrays.stream(participantString.split(","))
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public String getName(int index) {
        if (index < Constants.ZERO || index > this.participants.size()) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANT_INDEX);
        }
        return this.participants.get(index)
                .name();
    }

    public List<Participant> participants() {
        return participants;
    }

    public int size() {
        return this.participants.size();
    }

}
