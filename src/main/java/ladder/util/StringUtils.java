package ladder.util;

public class StringUtils {

    public static String center(String string, int size) {
        return center(string, size, ' ');
    }

    public static String center(String string, int size, char pad) {
        if (string == null || size <= string.length()) {
            return string;
        }

        StringBuilder stringBuilder = new StringBuilder(size);
        for (int i = 0; i < (size - string.length()) / 2; i++) {
            stringBuilder.append(pad);
        }
        stringBuilder.append(string);
        while (stringBuilder.length() < size) {
            stringBuilder.append(pad);
        }
        return stringBuilder.toString();
    }
}
