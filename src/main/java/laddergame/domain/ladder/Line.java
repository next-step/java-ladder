package laddergame.domain.ladder;

import laddergame.domain.Players;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.*;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;

public class Line {
    private static final int START_RANGE = 0;

    private final List<Link> links;

    private Line(List<Link> links) {
        this.links = links;
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
