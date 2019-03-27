package ladder.domain.member;

import org.apache.commons.lang3.StringUtils;

public class Member {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Member(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("It's not valid name");
        }

        this.name = name;
    }

    private boolean isValidName(String name) {
        return StringUtils.isNotBlank(name) && (name.length() <= MAX_NAME_LENGTH);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%" + MAX_NAME_LENGTH + "s", this.name);
    }
}
