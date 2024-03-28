package ladder2.domain;

import java.util.Objects;

public class LadderColumn {

    private final int index;
    private final Link link;

    public LadderColumn(int index, Link link) {
        this.index = index;
        this.link = link;
    }

    public int nextIndex() {
        return link.nextIndex(index);
    }

    public int index() {
        return index;
    }

    public Link link() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderColumn that = (LadderColumn) o;
        return Objects.equals(index, that.index) && link == that.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, link);
    }

    @Override
    public String toString() {
        return "LadderColumn{" +
            "index=" + index +
            ", link=" + link +
            '}';
    }
}
