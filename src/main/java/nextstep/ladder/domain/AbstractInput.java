package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.stream.Stream;
import nextstep.ladder.exception.InputNullPointerException;

public abstract class AbstractInput {

    protected static final String DELIMITER = ",";

    protected final String input;

    protected AbstractInput(String input) {
        valid(input);
        this.input = input;
    }

    protected Stream<String> getStream() {
        return Arrays.stream(input.split(DELIMITER));
    }

    private void valid(String input) {
        if (input == null || input.isEmpty()) {
            throw new InputNullPointerException();
        }
    }

}
