package domain.ladder;

import generator.bool.BooleansGenerator;
import generator.bool.impl.NonContinuousGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Point> points;

    public Ladder(int length, BooleanSupplier booleanSupplier) {
        this.points = Collections.unmodifiableList(createPoints(createLines(length, booleanSupplier)));
    }

    private List<Point> createPoints(List<Boolean> lines) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Direction direction = Direction.generate(lines, i);
            points.add(new Point(i, direction));
        }

        return points;
    }

    public static List<Boolean> createLines(int length, BooleanSupplier booleanSupplier) {
        BooleansGenerator generator = new NonContinuousGenerator(booleanSupplier, true);

        List<Boolean> lines = new ArrayList<>();
        initFirst(lines);
        initBody(lines, length, generator);

        return lines;
    }

    private static void initBody(List<Boolean> lines, int length, BooleansGenerator generator) {
        lines.addAll(generator.generate(length - 1));
    }

    private static void initFirst(List<Boolean> lines) {
        lines.add(Boolean.FALSE);
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
}
