package laddergame.domain.ladder;

import laddergame.domain.Players;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;
import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;
import static laddergame.exception.ExceptionMessage.WRONG_LINE_MESSAGE;

public class Line {
    private static final int START_RANGE = 0;

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

    public static Line newLine(List<Link> links) {
        return new Line(links);
    }

    public static Line newLine(Players players, LinkStrategy linkStrategy) {
        Deque<Link> links = new LinkedList<>();

        IntStream.range(START_RANGE, players.numberOfPlayers() - 1)
                .forEach(i -> links.add(nextLink(links, linkStrategy)));

        return new Line(new ArrayList<>(links));
    }

    private static Link nextLink(Deque<Link> links, LinkStrategy linkStrategy) {
        boolean linkable = linkStrategy.linkable();
        Link before = Optional.ofNullable(links.peekLast())
                .orElse(UNLINKED);

        return linkable && before.isUnLinked() ? LINKED : UNLINKED;
    }

    public List<Link> links() {
        return Collections.unmodifiableList(links);
    }
}
