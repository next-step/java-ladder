package ladder.view;

import ladder.Ladder;
import ladder.line.Line;

public class PrintView {

    private static final String STICK = "|";
    private static final String EMPTY_BAR = " ";
    private static final String SOLID_BAR = "-";

    public static void printLadder(Ladder ladder) {
        for (String name : ladder.getNames()) {
            printName(ladder.getMaxNameLength(), name);
        }
        System.out.println();

        for (int i = 0; i < ladder.getHeight(); i++) {
            printLine(ladder.getLine(i), ladder.getMaxNameLength());
        }
    }

    private static void printName(int maxNameLength, String name) {
        System.out.printf(EMPTY_BAR.repeat(maxNameLength - name.length() + 1) + name);
    }

    private static void printLine(Line line, int width) {
        for (Boolean bar : line.getBars()) {
            System.out.print(getBar(bar, width));
        }
        System.out.println();
    }

    private static String getBar(Boolean bar, int width) {
        if (bar) {
            return SOLID_BAR.repeat(width) + STICK;
        }
        return EMPTY_BAR.repeat(width) + STICK;
    }

}
