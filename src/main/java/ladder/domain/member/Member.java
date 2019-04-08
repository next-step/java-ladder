package ladder.domain.member;

import org.apache.commons.lang3.StringUtils;

public class Member {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Member(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name) || (MAX_NAME_LENGTH < name.length())) {
            throw new IllegalArgumentException("It's not valid name : " + name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
