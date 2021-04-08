package nextstep.ladder.util;

public final class StringUtils {

    private static final String WHITE_SPACE = " ";

    private StringUtils() {
    }

    public static String padToLeft(String str, int totalSize) {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() < totalSize - str.length()) {
            stringBuilder.append(WHITE_SPACE);
        }
        stringBuilder.append(str);

        return stringBuilder.toString();
    }

    public static String padToRight(String str, int totalSize) {
        StringBuilder stringBuilder = new StringBuilder(str);

        while (stringBuilder.length() < totalSize) {
            stringBuilder.append(WHITE_SPACE);
        }

        return stringBuilder.toString();
    }

    public static String repeat(String str, int times) {
        StringBuilder stringBuilder = new StringBuilder();

        while (times-- > 0) {
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }

}
