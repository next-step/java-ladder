package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import ladder.util.StringUtils;

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
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE);
        }

        List<Name> names = splitBy(input, DELIMITER);

        return new Participants(names);
    }

    private static List<Name> splitBy(String input, String delimiter) {
        return Arrays.stream(StringUtils.split(input, delimiter))
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
