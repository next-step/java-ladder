package nextstep.ladder.domain.user;

import java.util.Objects;

public class NameLength {

    private final int length;

    public NameLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NameLength that = (NameLength) o;
        return getLength() == that.getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLength());
    }
}
