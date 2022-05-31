package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Link> links;

    public Row(List<Link> links) {
        this.links = links;
    }

    public int move(int from) {
        return links.get(from).move();
    }

    public static Row createManual(List<Boolean> points) {
        if (points.size() < 3) {
            throw new IllegalArgumentException("size of points should be more than 3");
        }
        if (points.get(0) || points.get(points.size() - 1)) {
            throw new IllegalArgumentException("first and last should be false");
        }
        List<Link> links = Stream.iterate(Link.first(points.get(0)), link -> link.next(points.get(link.from() + 1)))
                .limit(points.size())
                .collect(Collectors.toList());
        return new Row(links);
    }

    public static Row createRandom(int width) {
        List<Link> links = Stream.iterate(Link.firstRandom(), link -> link.nextRandom())
                .limit(width - 1)
                .collect(Collectors.toList());
        links.add(links.get(width - 2).last());
        return new Row(links);
    }

    @Override
    public String toString() {
        return "Row{" +
                "links=" + links +
                '}';
    }

    public int size() {
        return this.links.size();
    }
}
