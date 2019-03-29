package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(final int countOfPerson) {
        int countOfLines = countOfPerson - 1;

        while (!points.contains(true)) {
            points = this.generate(countOfLines);
        }
    }

    private List<Boolean> generate(int countOfLines) {
        List<Boolean> points = new ArrayList<>();

        while (points.size() != countOfLines) {
            double random = Math.round(Math.random());
            points.add(random == 1);
        }

        return points;
    }

    public String paint() {
        StringBuilder result = new StringBuilder("|");
        final String lineLooks = "-----|";
        final String noneLooks = "     |";

        for (int i = 0; i < points.size(); i++) {
            if (canPaint(i)) {
                result.append(lineLooks);
                continue;
            }

            result.append(noneLooks);
        }

        return result.toString();
    }

    private boolean canPaint(int index) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }

        return points.get(index);
    }

    public boolean contains(boolean b) {
        return points.contains(b);
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
