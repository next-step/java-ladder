package ladder.utils;

public final class StringUtils {
    private StringUtils(){}

    public static String leftPad(String message, long size, String pad) {
        return String.format("%" + size + "s", message).replace(" ", pad);
    }

    public static String repeat(String text, int count) {
        return text.repeat(count);
    }
}
