package ladder.model;

import java.util.Objects;

public class MemberCount {
    private int count;

    public MemberCount(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Member count must be greater than zero.");
        }
        this.count = count;
    }

    public int toInt() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberCount)) return false;
        MemberCount that = (MemberCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
