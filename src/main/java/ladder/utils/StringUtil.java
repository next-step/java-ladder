package ladder.utils;

public class StringUtil {

    public static String fillRightBlank(String input, int fill) {
        return String.format("%-" + fill + "s", input);
    }

    public static String fillGivenString(String input, int count) {
        StringBuilder stringBu = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBu.append(input);
        }
        return stringBu.toString();
    }
}
