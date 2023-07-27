package nextstep.ladder.domain;

import java.util.Objects;

public abstract class LadderItem {

    private static final int NAME_MAX_LENGTH = 5;

    protected final String name;

    public LadderItem(String name) {
        nullCheck(name);

        name = name.trim();

        lengthCheck(name);

        this.name = name;
    }

    private void nullCheck(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(nullCheckErrorMessage());
        }
    }

    protected abstract String nullCheckErrorMessage();

    private void lengthCheck(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(lengthCheckErrorMessage());
        }
    }

    protected abstract String lengthCheckErrorMessage();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
