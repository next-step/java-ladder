package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Links {
    private final List<Link> links;

    public Links(final List<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links1 = (Links) o;
        return Objects.equals(links, links1.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links);
    }
}
