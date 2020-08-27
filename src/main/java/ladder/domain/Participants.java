package ladder.domain;

import ladder.exception.LadderExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class Participants {
    private static final String DELIMITER = ",";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int PARTICIPANTS_MIN_COUNT = 1;

    private List<String> names;

    private Participants(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public static Participants of(String input) {
        List<String> names = splitBy(input, DELIMITER);

        validate(names);

        return new Participants(names);
    }

    private static void validate(List<String> names) {
        if (names.size() <= PARTICIPANTS_MIN_COUNT) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE);
        }

        boolean hasLongName = names.stream()
                .anyMatch(name -> name.length() > NAME_MAX_LENGTH);

        if (hasLongName) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NAME_TOO_LONG);
        }
    }

    private static List<String> splitBy(String input, String delimiter) {
        if (input == null) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE);
        }

        return Arrays.asList(input
                .trim()
                .split(delimiter));
    }

    public int getNumber() {
        return names.size();
    }

    boolean isShortage() {
        return names.size() <= 1;
    }
}
