package ladder.domain;

import ladder.exception.BadNameException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    private static final int STANDARD_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if (name.length() > STANDARD_NAME_LENGTH) {
            throw BadNameException.getInstance();
        }
    }

    @Override
    public String toString() {
        String whitespaces = Stream.generate(() -> " ")
                .limit(STANDARD_NAME_LENGTH - name.length())
                .collect(Collectors.joining());
        return whitespaces + name;
    }
}
