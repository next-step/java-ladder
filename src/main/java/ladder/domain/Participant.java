package ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Participant {
    private final static int MAX_NAME_LENGTH = 5;

    private String name;

    public Participant(String arg) {
        Optional<String> name = Optional.ofNullable(arg);
        name.filter(text -> !text.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("participant name cannot be empty"));
        name.filter(text -> text.length() <= MAX_NAME_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException("participant name length cannot be longer than 5"));
        this.name = arg;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getNameSize() {
        return name.length();
    }
}
