package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String PARTICIPANTS_NULL_OR_EMPTY_ERROR_MESSAGE = "입력된 참가자들이 없습니다.";

    private final List<Participant> values;

    public Participants(List<Participant> values) {
        this.values = values;
    }

    public Participants(String[] names) {
        this(convertToList(names));
    }

    private static void validateNullAndEmpty(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException(PARTICIPANTS_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private static List<Participant> convertToList(String[] names) {
        validateNullAndEmpty(names);

        return Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }


    public List<Participant> getValues() {
        return values;
    }
}
