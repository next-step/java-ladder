package laddergame.util;

import laddergame.domain.ladder.line.Line;

public class StringUtils {
    private static final int NAME_WIDTH = 5;
    private static final String SPACE = " ";
    private static final String LINKING = "-----";
    private static final String NOT_LINKING = "     ";
    private static final String LINE_POINT = "|";
    private static final String ALL = "all";


    public static String fitSpace(String name) {
        StringBuilder fit = new StringBuilder();
        fit.append(SPACE);
        while (fit.length() + name.length() < NAME_WIDTH) {
            fit.append(SPACE);
        }
        fit.append(name);
        if (name.length() < NAME_WIDTH) {
            fit.append(SPACE);
        }
        return fit.toString();
    }

    public static String fitLine(Line line) {
        StringBuilder fit = new StringBuilder();
        line.isConnect()
                .forEach(connected -> fitConnect(connected, fit));
        return fit.toString();
    }

    private static void fitConnect(Boolean connected, StringBuilder fit) {
        if (connected) {
            fit.append(LINKING + LINE_POINT);
            return;
        }
        fit.append(NOT_LINKING + LINE_POINT);
    }

    public static boolean isAll(String input) {
        return input.equals(ALL);
    }
}
