package ladder.utils;

public final class StringFormatter {
    private StringFormatter(){}

    public static String rightPad(String message, long size, String pad) {
        return String.format("%-" + size + "s", message).replace(" ", pad);
    }
}
