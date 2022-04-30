package ladder.validator;

import ladder.exception.InvalidInputSizeException;
import ladder.model.ExecutionResults;
import ladder.model.Participants;

public class InputValidator {

    public static void validate(Participants participants, ExecutionResults executionResults) {
        if (participants.size() != executionResults.size()) {
            throw new InvalidInputSizeException(participants.size(), executionResults.size());
        }
    }

}
