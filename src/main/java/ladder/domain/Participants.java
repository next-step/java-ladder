package ladder.domain;

import ladder.common.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.common.ErrorMessage.NAME_CAN_NOT_BE_BLANK;
import static ladder.common.ErrorMessage.NAME_IS_TOO_LONG;

public class Participants {

    private static final String SPLIT_LETTER = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> value;

    public Participants(String names) {
        this.value = split(names);
    }

    private List<String> split(String names) {
        String[] dividedName = names.split(SPLIT_LETTER);
        List<String> participants =
                Arrays.stream(dividedName)
                        .map(this::valid)
                        .distinct()
                        .collect(Collectors.toList());

        if (participants.size() != dividedName.length) {
            throw new IllegalArgumentException(ErrorMessage.NAMES_CANNOT_BE_DUPLICATED);
        }

        return participants;
    }

    private String valid(String name) {
        if (name.isEmpty() | name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CAN_NOT_BE_BLANK);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_IS_TOO_LONG);
        }
        return name;
    }

    public int size() {
        return value.size();
    }

    public List<String> getValue() {
        return value;
    }
}
