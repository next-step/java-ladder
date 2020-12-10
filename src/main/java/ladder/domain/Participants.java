package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.common.ErrorMessage.NAME_CAN_NOT_BE_BLANK;
import static ladder.common.ErrorMessage.NAME_IS_TOO_LONG;

public class Participants {

    private static final String SPLIT_LETTER = ",";

    private final List<String> value;

    public Participants(String names) {
        this.value = split(names);
    }

    private List<String> split(String names) {
        return Arrays.stream(names.split(SPLIT_LETTER))
                .map(this::valid)
                .collect(Collectors.toList());
    }

    private String valid(String name) {
        if (name.isEmpty() | name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CAN_NOT_BE_BLANK);
        }

        if (name.length() > 5) {
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
