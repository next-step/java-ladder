package ladder.domain;

import ladder.exception.LadderExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final String DELIMITER = ",";
    private static final int PARTICIPANTS_MIN_COUNT = 1;

    private List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }

    public static Participants of(String input) {
        List<Name> names = splitBy(input, DELIMITER);

        return new Participants(names);
    }

    private static List<Name> splitBy(String input, String delimiter) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE);
        }

        return Arrays.stream(input
                .trim()
                .split(delimiter))
                .map(Name::from)
                .collect(Collectors.toList());
    }

    public int getNumber() {
        return names.size();
    }

    boolean isShortage() {
        return names.size() <= PARTICIPANTS_MIN_COUNT;
    }
}
