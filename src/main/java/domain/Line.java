package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    public static String BAR = "|";
    public static String LINE_LOOKS = "-";
    public static String LINE_LOOKS_NONE = " ";

    private List<Boolean> points = new ArrayList<>();

    protected Line(final int countOfLines) {
        while (!points.contains(true)) {
            points = this.generate(countOfLines);
        }
    }

    protected Line(List<Boolean> points) {
        if (!points.contains(true)) {
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    private List<Boolean> generate(int countOfLines) {
        List<Boolean> points = Stream.generate(() -> Math.round(Math.random()) == 1)
                .limit(countOfLines)
                .collect(Collectors.toList());

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

    protected boolean contains(boolean b) {
        return points.contains(b);
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
