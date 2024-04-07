package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;
import static laddergame.domain.ladder.Link.*;
import static laddergame.exception.ExceptionMessage.WRONG_LINE_MESSAGE;

public class Line {
    private final List<Link> links;

    public Line(List<Link> links) {
        validateLinks(links);
        this.links = links;
    }

    private void validateLinks(List<Link> links) {
        validateSizeOfLinks(links);
        validateFirstLinkedUnLinked(links.get(0), links.get(1));
        IntStream.range(2, links.size())
                .forEach(i -> validateOrderOfLinks(links.get(i - 1), links.get(i)));
    }

    private void validateSizeOfLinks(List<Link> links) {
        if (isNull(links) || links.isEmpty() || links.size() % 2 != 0) {
            throw new IllegalArgumentException(WRONG_LINE_MESSAGE.message());
        }
    }

    private void validateFirstLinkedUnLinked(Link firstOfLinkedUnLinked, Link secondOfLinkedUnLinked) {
        if (!isValidLinked(firstOfLinkedUnLinked, secondOfLinkedUnLinked) && !isValidUnLinked(firstOfLinkedUnLinked, secondOfLinkedUnLinked)) {
            throw new IllegalArgumentException(WRONG_LINE_MESSAGE.message());
        }
    }

    private boolean isValidLinked(Link firstOfLinked, Link secondOfLinked) {
        return firstOfLinked.isLinkedRight() && secondOfLinked.isLinkedLeft();
    }

    private boolean isValidUnLinked(Link firstOfUnLinked, Link secondOfUnLinked) {
        return firstOfUnLinked.isUnLinked() && secondOfUnLinked.isUnLinked();
    }

    private void validateOrderOfLinks(Link before, Link now) {
        if (!now.isValidBeforeLink(before)) {
            throw new IllegalArgumentException(WRONG_LINE_MESSAGE.message());
        }
    }

    public static Line newLine(int numberOfLinkedUnLinked, LinkStrategy linkStrategy) {
        Deque<Link> links = new LinkedList<>();

        IntStream.range(0, numberOfLinkedUnLinked)
                .forEach(i -> links.addAll(nextLink(links, linkStrategy)));

        return new Line(new ArrayList<>(links));
    }

    private static List<Link> nextLink(Deque<Link> links, LinkStrategy linkStrategy) {
        boolean linkable = linkStrategy.linkable();
        Link before = Optional.ofNullable(links.peekLast())
                .orElse(DOWN);

        return linkable && before.isUnLinked() ? List.of(RIGHT, LEFT) : List.of(DOWN, DOWN);
    }

    public int numberOfLinks() {
        return links.size();
    }

    public int numberOfLinkedUnLinked() {
        return links.size() / 2;
    }

    public int nextIndexOfColumn(int indexOfColumn) {
        return indexOfColumn
                + findLinkByIndex(2 * indexOfColumn - 1).value()
                + findLinkByIndex(2 * indexOfColumn).value();
    }

    private Link findLinkByIndex(int index) {
        try {
            return links.get(index);
        } catch (IndexOutOfBoundsException e) {
            return DOWN;
        }
    }

    public List<Link> links() {
        return Collections.unmodifiableList(links);
    }
}
