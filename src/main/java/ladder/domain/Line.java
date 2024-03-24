package ladder.domain;

import static ladder.domain.Link.LEFT_LINK;
import static ladder.domain.Link.RIGHT_LINK;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Link> links;

    private Line(List<Link> links) {
        this.links = links;
    }

    public static Line from(List<Link> links) {
        validate(links);
        List<Link> unmodifiableLinks = Collections.unmodifiableList(links);
        return new Line(unmodifiableLinks);
    }

    private static void validate(List<Link> links) {
        validateNotEmpty(links);
        validateNullLink(links);
        validateConsistency(links);
    }

    private static void validateNotEmpty(List<Link> links) {
        if (links.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNullLink(List<Link> links) {
        Link first = links.get(0);
        Link last = links.get(links.size() - 1);
        if (first == LEFT_LINK || last == RIGHT_LINK) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateConsistency(List<Link> links) {
        int secondFromBackIndex = links.size() - 2;
        for (int i = 0; i <= secondFromBackIndex; i++) {
            Link current = links.get(i);
            Link next = links.get(i + 1);
            validateConsistency(current, next);
        }
    }

    private static void validateConsistency(Link current, Link next) {
        boolean violation = (current == RIGHT_LINK && next != LEFT_LINK)
            || (current == LEFT_LINK && next == LEFT_LINK);
        if (violation) {
            throw new IllegalArgumentException();
        }
    }

    public List<Link> points() {
        return links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(links, line.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links);
    }

    @Override
    public String toString() {
        return "Line{" +
            "links=" + links +
            '}';
    }
}
