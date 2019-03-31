package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Line {
    public static final String BAR = "|";
    public static final String LINE_LOOKS = "-";
    public static final String LINE_LOOKS_NONE = " ";

    private final List<Boolean> points;

    Line(List<Boolean> points) {
        if (!points.contains(true)) {
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    public String paint(int spacingLetterLength) {
        final String lineLooks = StringUtils.repeat(LINE_LOOKS, spacingLetterLength) + BAR;
        final String noneLooks = StringUtils.repeat(LINE_LOOKS_NONE, spacingLetterLength) + BAR;

        StringBuilder result = new StringBuilder(BAR);

        for (Boolean point : points) {
            if (point) {
                result.append(lineLooks);
                continue;
            }

            result.append(noneLooks);
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
