package ladder.domain;

import java.util.Objects;

public class Link {
    private final boolean linked;

    public Link(final boolean linked) {
        this.linked = linked;
    }

    public boolean isLinked() {
        return linked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return linked == link.linked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linked);
    }
}
