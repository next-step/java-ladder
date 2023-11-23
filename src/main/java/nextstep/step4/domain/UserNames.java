package nextstep.step4.domain;

import java.util.List;

public class UserNames {
    private final List<String> names;

    public UserNames(final String names) {
        final String[] tempNames = names.split(",");

        validateNames(tempNames);

        this.names = List.of(tempNames);
    }

    private void validateNames(final String[] tempNames) {
        for (final String name : tempNames) {
            throwExceptionIfNameLengthIsLongerThan5(name);
        }
    }

    private void throwExceptionIfNameLengthIsLongerThan5(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자까지만 허용합니다.");
        }
    }
}
