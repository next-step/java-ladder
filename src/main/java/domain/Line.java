package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static String BAR = "|";
    public static String LINE_LOOKS = "-";
    public static String LINE_LOOKS_NONE = " ";

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

    public String paint(int spacingLetterLength) {
        StringBuilder result = new StringBuilder(BAR);
        final String lineLooks = StringUtils.repeat(LINE_LOOKS, spacingLetterLength) + BAR;
        final String noneLooks = StringUtils.repeat(LINE_LOOKS_NONE, spacingLetterLength) + BAR;

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
