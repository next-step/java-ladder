package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participant {

    private static final String DELIMITER = ",";
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private static final String ERR_MORE_THEN_ONE_NAME = "이름은 2개 이상 입력해주세요.";
    private static final String ERR_TOO_LONG_NAME = "한 사람당 이름은 5자까지만 입력해주세요.";

    private final List<String> names;

    public Participant(String nameStr) {
        this.names = splitNameToList(nameStr);
    }

    private List<String> splitNameToList(String nameStr) {

        verifyEmptyName(nameStr);

        List<String> names = Arrays.stream(nameStr.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        verifyNameCount(names);
        verifyNameLength(names);

        return names;
    }

    private void verifyEmptyName(String nameStr) {
        if (nameStr == null || nameStr.isEmpty()) {
            throw new IllegalArgumentException(ERR_MORE_THEN_ONE_NAME);
        }
    }

    private void verifyNameLength(List<String> names) {
        if (hasLongName(names)) {
            throw new IllegalArgumentException(ERR_TOO_LONG_NAME);
        }
    }

    private boolean hasLongName(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.length() > MAXIMUM_NAME_LENGTH);
    }

    private void verifyNameCount(List<String> names) {
        if (names.size() <= MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_MORE_THEN_ONE_NAME);
        }
    }

    public List<String> getNames() {
        return names;
    }
}
