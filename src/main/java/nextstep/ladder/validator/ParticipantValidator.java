package nextstep.ladder.validator;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.exception.ParticipantNameLengthExceedException;

import java.util.List;

public class ParticipantValidator {

    public static void validateNamesLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    public static void validateNameLength(String name) throws ParticipantNameLengthExceedException {
        if (exceedNameLength(name)) {
            throw new ParticipantNameLengthExceedException(name);
        }
    }

    private static boolean exceedNameLength(String name) {
        int nameLength = name.length();
        return nameLength < Participant.MIN_NAME_LENGTH || nameLength > Participant.MAX_NAME_LENGTH;
    }

}
