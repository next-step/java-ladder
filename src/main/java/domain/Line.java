package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generate(int width, Random random) {
        List<Boolean> points = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < width - 1; i++) {
            boolean point = !prev && random.nextBoolean();
            points.add(point);
            prev = point;
        }
        return new Line(points);
    }

    public int getNextPosition(int position) {
        if (position < points.size() && points.get(position)) {
            return position + 1;
        }
        if (position > 0 && points.get(position - 1)) {
            return position - 1;
        }
        return position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("    ");
        for (Boolean point : points) {
            sb.append(point ? "|-----" : "|     ");
        }
        sb.append("|");
        return sb.toString();
    }

    public int move(int position) {
        if (position > 0 && points.get(position - 1)) {
            return position - 1;
        }
        if (position < points.size() && points.get(position)) {
            return position + 1;
        }
        return position;
    }
}
