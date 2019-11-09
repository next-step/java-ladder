package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderRow {
    private final List<Link> links;

    public LadderRow(final List<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRow that = (LadderRow) o;
        return links == that.links;
    }

    @Override
    public int hashCode() {
        return Objects.hash(links);
    }
}
