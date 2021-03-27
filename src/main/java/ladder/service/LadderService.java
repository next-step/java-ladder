package ladder.service;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LadderService {

    public List<String> verifiedParticipants(String participantString) {
        if (!validParticipantsRegex(participantString)) {
            throw new CustomException(ErrorCode.INVALID_PARTICIPANTS_INPUT);
        }
        List<String> participants = participants(participantString);
        if(!validParticipantsName(participants)){
            throw new CustomException(ErrorCode.INVALID_PARTICIPANTS_NAME);
        }
        return participants;
    }

    private boolean validParticipantsName(List<String> participants) {
        return participants.size() == (int)participants.stream()
                .filter(participant -> participant.length()<=5)
                .count();
    }

    private List<String> participants(String participantString) {
        return Arrays.stream(participantString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }


    private boolean validParticipantsRegex(String participantString) {
        return Pattern.matches("[A-Za-z, ]+", participantString);
    }

}
