package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Spot> spots;

    public Row(List<Spot> spots) {
        this.spots = spots;
    }

    public int move(int index) {
        return spots.get(index).move(index);
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
