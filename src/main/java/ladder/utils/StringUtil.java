package ladder.utils;

public final class StringUtil {

    private StringUtil() {
    }

    public static String fillRightBlank(final String input, final int fill) {
        return String.format("%-" + fill + "s", input);
    }

    public static String fillGivenString(final String input, final int count) {
        StringBuilder stringBu = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBu.append(input);
        }
        return stringBu.toString();
    }
}
