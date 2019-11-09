package ladder.domain;

import java.util.Objects;

public class LadderRow {
    private final Lines lines;
    private final Links links;

    public LadderRow(final Lines lines, final Links links) {
        this.lines = lines;
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRow ladderRow = (LadderRow) o;
        return Objects.equals(lines, ladderRow.lines) &&
                Objects.equals(links, ladderRow.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, links);
    }
}
