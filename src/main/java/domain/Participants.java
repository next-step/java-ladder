package domain;

import java.util.Arrays;
import java.util.List;

public class Participants {

    private static final String SEPARATOR = ",";
    private static final String NAME_OUTPUT_FORMAT = "%6s";
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final List<String> names;

    private Participants(List<String> names) {
        this.names = validateNames(names);
    }

    public static Participants fromInput(String input) {
        return new Participants(Arrays.asList(input.split(SEPARATOR)));
    }

    private List<String> validateNames(List<String> names) {
        if (names.stream().anyMatch(s -> s.length() > MAXIMUM_LENGTH_OF_NAME)) {
            throw new IllegalArgumentException("이름은 5자 이하여야 한다.");
        }

        return names;
    }

    public int countOfParticipants() {
        return names.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        names.forEach(name -> stringBuilder.append(String.format(NAME_OUTPUT_FORMAT, name)));

        return stringBuilder.toString();
    }
}
