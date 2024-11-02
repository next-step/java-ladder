package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Link> links;

    public Line(boolean... links) {
        this.links = IntStream.range(0, links.length)
                .mapToObj(i -> new Link(links[i]))
                .collect(Collectors.toList());
    }

    private Line(List<Link> links) {
        this.links = links;
    }

    public static List<Line> createLines(int countOfLine, int countOfLink) {
        return IntStream.range(0, countOfLine)
                .mapToObj(number -> createLine(countOfLink))
                .collect(Collectors.toList());
    }

    private static Line createLine(int countOfLink) {
        List<Link> links = new ArrayList<>(List.of(new Link()));
        IntStream.range(1, countOfLink)
                .forEach(number -> {
                    Link currentLink = links.get(links.size() - 1);
                    links.add(currentLink.createNextLink());
                });

        return new Line(links);
    }

    public boolean hasCountOfLink(int count) {
        return links.size() == count;
    }

    public List<Link> getLinks() {
        return new ArrayList<>(links);
    }

    public List<Integer> move(List<Integer> positions) {
        List<Integer> movedPositions = new ArrayList<>(positions);
        ListIterator<Link> links = this.links.listIterator();

        links.forEachRemaining(link -> {
            if (link.isExist()) {
                int indexOfLink = links.nextIndex();

                movedPositions.set(indexOfLink, positions.get(indexOfLink + 1));
                movedPositions.set(indexOfLink + 1, positions.get(indexOfLink));
            }
            links.next();
        });

        return movedPositions;
    }
}
