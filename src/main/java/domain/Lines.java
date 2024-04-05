package domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines implements Iterable<Line> {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines from(List<Line> lines) {
        return new Lines(lines);
    }

    public static Lines of(int count, int height) {
        return of(count, height, new RandomBridgeCreationStrategy());
    }

    public static Lines of(int count, int height, BridgeCreationStrategy strategy) {
        return of(count, new Height(height), strategy);
    }

    public static Lines of(int count, Height height, BridgeCreationStrategy strategy) {
        List<Line> lines = IntStream.range(0, count)
            .mapToObj(i -> Line.createWithBridges(height, strategy))
            .collect(Collectors.toList());

        removeBridgeIfPreviousBridgeExist(count, lines);
        return new Lines(lines);
    }

    private static void removeBridgeIfPreviousBridgeExist(int count, List<Line> lines) {
        Line prev = lines.get(0);
        for (int i = 1; i < count; i++) {
            Line cur = lines.get(i);
            cur.resetBridges(prev);
            prev = cur;
        }
    }

    public void accept(LadderVisitor visitor) {
        visitor.visit(lines, lines.get(0).height());
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
