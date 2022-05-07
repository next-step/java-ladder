package ladder.domain;

import ladder.exception.InvalidNameOfReulstException;
import ladder.exception.InvalidNumberOfResultException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResult {
    private static final String SEPARATOR_OF_NAMES = ",";

    private final String[] input;
    private final List<String> result;

    public GameResult(String inputs, Participants participants) {
        String[] input = inputs.split(SEPARATOR_OF_NAMES);
        validateNumberOfResult(input, participants);
        validateNameOfResult(input);
        this.input = input;
        result = new ArrayList<>();
    }

    void validateNumberOfResult(String[] inputs, Participants participants) {
        if (inputs.length != participants.getNumberOfParticipants()) {
            throw new InvalidNumberOfResultException(inputs.length, participants.getNumberOfParticipants());
        }
    }

    void validateNameOfResult(String[] inputs) {
        for (String input : inputs) {
            validateNameOfResult(input);
        }
    }

    private void validateNameOfResult(String input) {
        if (input.length() == 0) {
            throw new InvalidNameOfReulstException(input);
        }
    }

    void save(int indexOfParticipants, int result) {
        this.result.add(indexOfParticipants, String.valueOf(result));
    }

    int getNumberOfResults() {
        return input.length;
    }

    public List<String> getInputOfResults() {
        return Arrays.asList(input);
    }
}
