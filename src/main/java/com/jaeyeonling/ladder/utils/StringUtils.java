package com.jaeyeonling.ladder.utils;

public final class StringUtils {

    private StringUtils() { }

    public static boolean isNullOrEmpty(final String str) {
        return str == null || str.isEmpty();
    }

    public static String rightAlign(final String alignTarget,
                                    final int length) {
        final String format = String.format("%s%d%s", "%", length, "s");
        return String.format(format, alignTarget);
    }

    public static boolean isOverLength(final String comparisonTarget,
                                       final int length) {
        return comparisonTarget.length() > length;
    }
}
