package nextstep.ladder2.domain.prize;

import java.util.Objects;

public class NxPrize {
    private final String prizeName;

    public NxPrize(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeName() {
        return prizeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NxPrize nxPrize = (NxPrize) o;
        return Objects.equals(prizeName, nxPrize.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }
}
