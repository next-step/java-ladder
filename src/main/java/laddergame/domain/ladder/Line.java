package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;
import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;
import static laddergame.exception.ExceptionMessage.WRONG_LINE_MESSAGE;

public class Line {
    private final List<Link> links;

    public Line(List<Link> links) {
        validateLinks(links);
        this.links = links;
    }

    private void validateLinks(List<Link> links) {
        if (isNull(links) || links.isEmpty()) {
            throw new IllegalArgumentException(WRONG_LINE_MESSAGE.message());
        }

        IntStream.range(1, links.size())
                .forEach(i -> validateOverlapLinked(links.get(i - 1), links.get(i)));
    }

    private void validateOverlapLinked(Link before, Link now) {
        if (before.isLinked() && now.isLinked()) {
            throw new IllegalArgumentException(WRONG_LINE_MESSAGE.message());
        }
    }

    public static Line newLine(int numberOfLink, LinkStrategy linkStrategy) {
        Deque<Link> links = new LinkedList<>();

        IntStream.range(0, numberOfLink)
                .forEach(i -> links.add(nextLink(links, linkStrategy)));

        return new Line(new ArrayList<>(links));
    }

    private static Link nextLink(Deque<Link> links, LinkStrategy linkStrategy) {
        boolean linkable = linkStrategy.linkable();
        Link before = Optional.ofNullable(links.peekLast())
                .orElse(UNLINKED);

        return linkable && before.isUnLinked() ? LINKED : UNLINKED;
    }

    public int numberOfLinks() {
        return links.size();
    }

    public int nextIndexOfColumn(int indexOfColumn) {
        int indexOfLeftLink = indexOfColumn - 1;
        if (isValidIndexOfLink(indexOfLeftLink) && links.get(indexOfLeftLink).isLinked()) {
            return indexOfColumn - 1;
        }

        int indexOfRightLink = indexOfColumn;
        if (isValidIndexOfLink(indexOfRightLink) && links.get(indexOfRightLink).isLinked()) {
            return indexOfColumn + 1;
        }

        return indexOfColumn;
    }

    private boolean isValidIndexOfLink(int indexOfLink) {
        return indexOfLink >= 0 && indexOfLink < links.size();
    }

    public List<Link> links() {
        return Collections.unmodifiableList(links);
    }
}
