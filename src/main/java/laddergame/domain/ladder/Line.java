package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.*;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;

public class Line {
    private static final int START_RANGE = 0;

    private final List<Link> links;

    private Line(int numberOfPlayers, LinkStrategy linkStrategy) {
        Deque<Link> links = new LinkedList<>();

        IntStream.range(START_RANGE, numberOfPlayers - 1)
                .forEach(i -> {
                    boolean linkable = linkStrategy.linkable();
                    Link before = Optional.ofNullable(links.peekLast())
                            .orElse(UNLINKED);
                    links.add(linkable && before.isUnLinked() ? LINKED : UNLINKED);
                });

        this.links = new ArrayList<>(links);
    }

    public static Line newLine(int numberOfPlayers, LinkStrategy linkStrategy) {
        return new Line(numberOfPlayers, linkStrategy);
    }

    public List<Link> links() {
        return links;
    }
}
