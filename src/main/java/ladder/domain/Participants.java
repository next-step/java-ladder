package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Participants {

    public static final String NAMES_CANNOT_BE_DUPLICATED = "Names cannot be duplicated.";
    public static final String NAME_CAN_NOT_BE_BLANK = "Name can not be blank.";
    public static final String NAME_IS_TOO_LONG = "Name is too long.";
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
                        .distinct()
                        .map(this::valid)
                        .collect(Collectors.toList());

        if (participants.size() != dividedName.length) {
            throw new IllegalArgumentException(NAMES_CANNOT_BE_DUPLICATED);
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
