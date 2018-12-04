package ladder.utils;

import ladder.domain.Direction;

public class StringUtils {

    private StringUtils() {

    }

    public static String direction(Direction direction) {
        if (direction.isNone()) return "  |  ";
        if (direction.isRight()) return "  |--";
        if (direction.isLeft()) return "--|  ";
        return "  |  ";
    }

    public static String center(String text) {
        int width = 4;

        int padSize = width - text.length();
        int padStart = text.length() + padSize / 2;

        text = String.format("%" + padStart + "s", text);
        text = String.format("%-" + width + "s", text);

        return text;
    }
}
