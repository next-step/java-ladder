package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPoints) {
        points = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < countOfPoints; i++) {
            boolean previous = (i > 0) && points.get(i - 1);
            points.add(!previous && random.nextBoolean());
        }
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for (boolean point : points) {
            builder.append("|");
            builder.append(point ? "-----" : "     ");
        }
        builder.append("|");
        System.out.println(builder);
    }
}
