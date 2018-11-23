package ladder.utils;

public class StringUtils {

    private StringUtils() {

    }

    public static String center(String text) {
        int width = 4;

        int padSize = width - text.length();
        int padStart = text.length() + padSize / 2;

        text = String.format("%" + padStart + "s", text);
        text = String.format("%-" + width  + "s", text);

        return text;
    }
}
