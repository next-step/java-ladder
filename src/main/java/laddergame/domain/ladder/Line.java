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

    private Line(List<Link> links) {
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

    public static Line valueOf(List<Link> links) {
        return new Line(links);
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

    public static Line newLine(Link... links) {
        return new Line(List.of(links));
    }

    public int numberOfLinks() {
        return links.size();
    }

    public int nextIndexOfFrame(int indexOfFrame) {
        int indexOfLeftLink = indexOfFrame - 1;
        if (isValidIndexOfLink(indexOfLeftLink) && links.get(indexOfLeftLink).isLinked()) {
            return indexOfFrame - 1;
        }

        int indexOfRightLink = indexOfFrame;
        if (isValidIndexOfLink(indexOfRightLink) && links.get(indexOfRightLink).isLinked()) {
            return indexOfFrame + 1;
        }

        return indexOfFrame;
    }

    private boolean isValidIndexOfLink(int indexOfLink) {
        return indexOfLink >= 0 && indexOfLink < links.size();
    }

    public List<Link> links() {
        return Collections.unmodifiableList(links);
    }
}
