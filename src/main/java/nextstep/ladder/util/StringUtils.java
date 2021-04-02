package nextstep.ladder.util;

public final class StringUtils {

    private StringUtils() {}

    public static String padToLeft(String str, int totalSize) {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() < totalSize - str.length()) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(str);

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
