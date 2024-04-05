package domain;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
        visitor.visit(lines, lines.get(0).getHeight());
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }

    public Position move(Position position) {
        return moveRight(position).orElseGet(() -> moveLeft(position)
            .orElseGet(() -> Position.from(position)));
    }

    private Optional<Position> moveLeft(Position position) {
        if (position.getX() == 0) {
            return Optional.empty();
        }
        if (lines.get(position.getX() - 1).hasBridge(position)) {
            return Optional.of(new Position(position.getX() - 1, position.getY()));
        }
        return Optional.empty();
    }

    private Optional<Position> moveRight(Position position) {
        Line line = lines.get(position.getX());
        if (line.hasBridge(position)) {
            return Optional.of(new Position(position.getX() + 1, position.getY()));
        }
        return Optional.empty();
    }

    public int getHeight() {
        return this.lines.get(0).getHeight();
    }
}
