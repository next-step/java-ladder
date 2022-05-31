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
        int width = this.links.size() - 1;
        if (from > width) {
            throw new IndexOutOfBoundsException("Cannot move from out of width (0 ~ " + width + ") but, " + from);
        }
        return links.get(from).move();
    }

    public static Row createManual(List<Boolean> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("width of row should be more than 3");
        }
        List<Link> links = Stream.iterate(Link.first(points.get(0)), link -> link.next(points.get(link.from() + 1)))
                .limit(points.size())
                .collect(Collectors.toList());
        links.add(links.get(links.size() - 1).last());
        return new Row(links);
    }

    public static Row createRandom(int width) {
        List<Link> links = Stream.iterate(Link.firstRandom(), link -> link.nextRandom())
                .limit(width)
                .collect(Collectors.toList());
        links.add(links.get(width - 1).last());
        return new Row(links);
    }

    @Override
    public String toString() {
        return "Row{" +
                "links=" + links +
                "}\n";
    }

    public int size() {
        return this.links.size();
    }

    public String toShow() {
        return " ".repeat(4) + "|" +
                this.links
                        .stream()
                        .map(link -> link.toShow())
                        .reduce((acc, cur) -> acc + "|" + cur).orElseThrow(() -> new RuntimeException("noting to show"))
                + "\n";
    }
}
