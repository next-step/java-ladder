package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Spot> spots;

    public Row(List<Spot> spots) {
        this.spots = spots;
    }

    public int move(int from) {
        int width = this.spots.size() - 1;
        if (from > width) {
            throw new IndexOutOfBoundsException("Cannot move from out of width (0 ~ " + width + ") but, " + from);
        }
        return spots.get(from).move();
    }

    public static Row createManual(List<Boolean> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("width of row should be more than 3");
        }
        List<Spot> spots = Stream.iterate(Spot.first(points.get(0)), spot -> spot.next(points.get(spot.from() + 1)))
                .limit(points.size())
                .collect(Collectors.toList());
        spots.add(spots.get(spots.size() - 1).last());
        return new Row(spots);
    }

    public static Row createRandom(int width) {
        List<Spot> spots = Stream.iterate(Spot.firstRandom(), spot -> spot.nextRandom())
                .limit(width)
                .collect(Collectors.toList());
        spots.add(spots.get(width - 1).last());
        return new Row(spots);
    }

    @Override
    public String toString() {
        return "Row{" +
                "spots=" + spots +
                "}\n";
    }

    public int size() {
        return this.spots.size();
    }

    public String toShow() {
        return " ".repeat(4) + "|" +
                this.spots
                        .stream()
                        .map(spot -> spot.toShow())
                        .reduce((acc, cur) -> acc + "|" + cur).orElseThrow(() -> new RuntimeException("noting to show"))
                + "\n";
    }
}
