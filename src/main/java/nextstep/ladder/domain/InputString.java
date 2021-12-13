package nextstep.ladder.domain;

import nextstep.ladder.exception.InputNullPointerException;

public class InputString {

    private static final String DELIMITER = ",";

    private final String input;

    public InputString(String input) {
        valid(input);
        this.input = input;
    }

    public String[] split() {
        return input.split(DELIMITER);
    }

    private void valid(String input) {
        if (input == null || input.isEmpty()) {
            throw new InputNullPointerException();
        }
    }

}
