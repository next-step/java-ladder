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

    int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }

    public Integer move(Integer position) {
        int left = 0;
        int right = 0;

        if (position == 0) {
            left = 0;
        }

        if (position > 0) {
            left = points.get(position - 1) ? -1 : 0;
        }

        if (position == points.size()) {
            right = 0;
        }

        if (position < points.size()) {
            right = points.get(position) ? 1 : 0;
        }

        int result = position + (left + right);

        return result;
    }
}
