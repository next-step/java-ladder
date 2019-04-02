package domain.ladder;

import generator.bools.BooleansGenerator;
import generator.bools.impl.NonContinuousGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class Ladder {

    private static final boolean LINE = true;

    private final List<Point> points;

    public Ladder(int lineSize, BooleanSupplier booleanSupplier) {
        this.points = Collections.unmodifiableList(createPoints(createLines(lineSize, booleanSupplier)));
    }

    private List<Point> createPoints(List<Boolean> lines) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Direction direction = Direction.generate(lines, i);
            points.add(new Point(i, direction));
        }

        return points;
    }

    public static List<Boolean> createLines(int size, BooleanSupplier booleanSupplier) {
        BooleansGenerator generator = new NonContinuousGenerator(booleanSupplier, LINE);

        List<Boolean> lines = new ArrayList<>();
        lines.add(!LINE);
        lines.addAll(generator.generate(size - 1));

        return lines;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public String beautify() {
        return this.points.stream()
                .map(point -> point.beautify())
                .collect(Collectors.joining());
    }

    public List<Point> getPoints() {
        return points;
    }

    public int lineSize() {
        return this.points.size();
    }
}
