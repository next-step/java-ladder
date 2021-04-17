package laddergame.util;

import laddergame.domain.ladder.line.Line;

public class StringUtils {
    public static final int NAME_WIDTH = 5;
    public static final String SPACE = " ";
    public static final String LINKING = "-----";
    public static final String NOT_LINKING = "     ";
    public static final String LINE_POINT = "|";


    public static String fitName(String name) {
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
}
