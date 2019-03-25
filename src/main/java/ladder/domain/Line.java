package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final int STARTING_POINT = 0;
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generate(int height) {
        List<Boolean> generatedPoints = new ArrayList<>();
        IntStream.range(0, height)
            .forEach(i -> generatedPoints.add(fillCurrent(generatedPoints, i)));
        return new Line(generatedPoints);
    }

    private static Boolean fillCurrent(List<Boolean> generatedPoints, int position) {
        if (position == STARTING_POINT)
            return false;

        Boolean randomBoolean = new Random().nextBoolean();

        if (isOverlap(generatedPoints.get(position - 1), randomBoolean)) {
            return !randomBoolean;
        }

        return randomBoolean;
    }

    static boolean isOverlap(Boolean beforeBoolean, Boolean randomBoolean) {
        return beforeBoolean && randomBoolean;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.points.forEach(point -> builder.append(beautify(point)).append("l"));
        return builder.toString();
    }

    public static String beautify(Boolean point) {
        StringBuilder builder = new StringBuilder();
        String fill = " ";
        if (point) {
            fill = "-";
        }
        for (int i = 0; i < Person.MAX_NAME_LENGTH; i++) {
            builder.append(fill);
        }
        return builder.toString();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
