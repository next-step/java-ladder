package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participant {

    public static final int MAX_LENGTH = 5;
    private final String name;

    private Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("participant must have name");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("name length must be equal or shorter than " + MAX_LENGTH);
        }
    }

    public static List<Participant> createParticipants(List<String> names) {
        return names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
