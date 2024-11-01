package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Link {
    private final static Random random = new Random();
    private final boolean link;

    public Link() {
        this.link = random.nextBoolean();
    }

    public Link(boolean link) {
        this.link = link;
    }

    public boolean isExist() {
        return this.link;
    }

    public Link createNextLink() {
        return new Link(!this.link && random.nextBoolean());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link1 = (Link) o;
        return link == link1.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(link);
    }
}
