package ladder.domain;

import ladder.util.StringUtils;

import java.util.List;

public class Player {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String ERR_TOO_LONG_NAME = "한 사람당 이름은 5자까지만 입력해주세요.";

    private final List<String> names;

    public Player(String nameStr) {
        this.names = StringUtils.splitStringToList(nameStr);
        verifyNameLength(names);
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

    public List<String> getNames() {
        return names;
    }
}
