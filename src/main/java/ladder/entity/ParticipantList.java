package ladder.entity;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantList {

    private List<Participant> participants;

    public ParticipantList(String stringNames) {
        this.participants = verifiedParticipants(stringNames);
    }

    private List<Participant> verifiedParticipants(String stringNames) {
        return Arrays.stream(stringNames.split(","))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public Participant get(int index) {
        if (index < 0 || index >= this.participants.size()) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANT_INDEX);
        }
        return this.participants.get(index);
    }

    public int size() {
        return this.participants.size();
    }
}
